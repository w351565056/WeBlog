$(function () {
    var nowuserid;
    $.ajax({
        url:"/getSessionServlet",
        type:"post",
        async :false,
        dataType:"json",
        success:function (result) {
            nowuserid=result.USER_ID;
        }
    })
    var num = 0;
    var imgpath = new Array();
    var index = 0;
    var forward = 0;
    var forwardblogcontent;
    var imgopen = null;//图片界面打开的标志
    var videoopen = null;//视频界面打开的标志
    var regImg = /image/;

    function openBlogPublish() {
        layer.open({
            type: 1,
            area: ['500px', '240px'],
            title: '有什么新鲜事想告诉大家？',
            shade: 0.3, //遮罩透明度,
            offset: ['10px', '400px'],
            closeBtn: 1,
            anim: 5,
            content: '<form enctype="multipart/form-data">' + '<div id="layer-body">' +
            '<div class="layer-body-center">' +
            '<textarea  name="desc" placeholder="说点儿什么吧" class="blogtextareappu layui-textarea text"></textarea>' +
            '</div>' +
            '<div class="layer-body-footer">' +
            '<span class="emo layui-icon layui-icon-face-surprised smile"></span>' +
            '<span class="puimg layui-icon layui-icon-picture pic"></span>' +
            '<span class="puvideo layui-icon layui-icon-video vid"></span>' +
            '<button class="pupublish layui-btn layui-btn-warm btn-fabu">发布</button>' +
            '</div>' + '<input id="videoupload" class="videoupload" type="file" name="files" multiple="multiple" style="display:none">' +
            '</div>' + '</form>'
            , cancel: function () {
                layer.closeAll();
                imgopen = null;
                videoopen = null;
            }

        })
    }//打开微博发布界面

    function openImgUpload() {
        layer.close(imgopen);
        imgopen = layer.open({
            type: 1,
            title: false,
            shade: 0, //遮罩透明度,
            offset: ['240px', '425px'],
            anim: 5,
            content: '<div class="insert_img">\n' +
            '    <div class="title">本地上传</div>\n' +
            '    <div class="titlesec">共<span class="nownum">0</span>张，还能上传<span class="remainnum">9</span>张</div>\n' +
            // '    <div class="attention_button ">\n' +
            // '        <a>\n' +
            // '            <span class="attention_add">+</span>\n' +
            // '            <span class="attention_text">标签</span>\n' +
            // '        </a>\n' +
            // '    </div>\n' +
            '    <ul class="add_area">\n' +
            '        <div id="effect-6" class="effects clearfix" style="display: inline-block">\n' +
            '            <li class="add"><a class="add_a"></a>\n' +
            '\n' +
            '            </li>\n' +
            '        </div>\n' +
            '    </ul>\n' +
            '    <input id="fileupload" class="fileupload" type="file" name="files" multiple="multiple" style="display: none">\n' +
            '</div>'
            , cancel: function () {
                imgopen = null;
            }
        })
    }//打开图片上传界面


    function forwardImgUpload() {
        $(".add").click(function () {
            $("#fileupload").trigger("click");
        })
        $('.fileupload').fileupload({
            url: "/uploadFile",
            Type: 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
            dataType: 'json',//服务器返回的数据类型
            singleFileUploads: false,//不设置多个文件循环提交，设置后一起提交

            //add函数为选择文件后执行的操作
            add: function (e, data) {
                if (!regImg.test(data.files[0].type)) {
                    layer.msg('只能上传图片哦', {icon: 0});
                } else {
                    num++;
                    $(".nownum").text(num);
                    $(".remainnum").text(9 - num);
                    //获取图片路径并显示预览
                    var url = getUrl(data.files[0]);
                    var $img = $(' <div class="img">\n' +
                        '            <img src=' + url + ' alt="" width="80px" height="80px">\n' +
                        '            <div class="overlay">\n' +
                        '                <a class="close-overlay">x</a>\n' +
                        '            </div>\n' +
                        '        </div>');
                    $(".add:last-child").append($img);
                    //预览之后解除选择图片的事件绑定
                    $(".add").unbind();
                    //增加新的操作
                    // $(".add").hover(function () {
                    //     $(this).css("background-color","#666666");
                    // })
                    $(".add").click(function () {
                        $(this).remove();
                        data = null;
                        num--;
                        $(".nownum").text(num);
                        $(".remainnum").text(9 - num);
                        if (num == 0) {
                            var newadd = $('<li id="add" class="add"><a></a></li>');
                            newadd.click(function () {
                                $("#fileupload").trigger("click");
                            })
                            $(".effects").append(newadd);
                        }
                    });
                    //绑定上传提交事件
                    $(".pupublish").click(function () {
                        data.submit();
                        event.preventDefault();
                    });
                }
            },
            //done函数为上传成功后执行的操作
            done: function (e, ret) {
                if (ret.result.errno == 0) {
                    imgpath[index] = ret.result.data[0];
                    index++;
                    num--;
                } else {
                    layer.msg('上传失败', {icon: 2});
                }
                if (num == 0) {//图片上传完毕提交文本内容和图片路径
                    var blogcontentpu = $(".blogtextareappu").val();
                    $.ajax({
                        url: "/InsertBlogServlet",
                        type: "post",
                        data: {"blogcontent": blogcontentpu, "imgpath": JSON.stringify(imgpath), "forward": forward,"userid":nowuserid},
                        success: function () {
                            layer.closeAll();
                            layer.msg('发布成功', {icon: 1});
                            videoopen=null;
                            imgopen=null;
                            $('#home_blog_content_show').load('blogcontent.html');
                        }
                    })
                }
            },
        });
    }//转发的图片上传(只能插入一张图片)


    function checkInput() {
        $(".pupublish").attr("disabled", "disabled").css({"background": "#ffc09f", "border": "1px solid #fbbd9e"});
        $(".blogtextareappu").keyup(function () { //无文字输入时不可点击
            if ($(".blogtextareappu").val() == "") {
                $(".pupublish").attr("disabled", "disabled").css({
                    "background": "#ffc09f",
                    "border": "1px solid #fbbd9e"
                });
            } else {
                $(".pupublish").removeAttr("disabled").css({"background": "#ff8140", "border": "1px solid #f77c3d"});
            }

        })
    }//检测用户是否输入

    function getUrl(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }//获取图片地址


    $.fn.selectRange = function (start, end) {
        if (end === undefined) {
            end = start;
        }
        return this.each(function () {
            if ('selectionStart' in this) {
                this.selectionStart = start;
                this.selectionEnd = end;
            } else if (this.setSelectionRange) {
                this.setSelectionRange(start, end);
            } else if (this.createTextRange) {
                var range = this.createTextRange();
                range.collapse(true);
                range.moveEnd('character', end);
                range.moveStart('character', start);
                range.select();
            }
        });
    };//控制光标位置


    //--------------转发
    $("#result").on("click", ".forward", function () { //转发微博

        var $blogword = $(this).closest($(".blogcontent_body")).find("p");//该元素下包含微博文本及表情
        var blogid = $(this).closest($(".blogcontent_main")).attr("blogid");//转发微博的blog_id
        var userna = $(this).closest($(".blogcontent_main")).attr("userna");//转发微博的user_name
        forward = $(this).closest($(".blogcontent_main")).attr("forward");//转发微博的forward(转发状态)

        openBlogPublish();
        layer.title("转发微博", index);
        $(".puvideo").css("display", "none");
        $(".pupublish").text("转发");
        checkInput();
        if (forward != 0) { //如果被转发的微博还有转发，则需要拼接用户输入和该微博内容
            $.ajax({
                url: "/ShowOneContentServlet",
                type: "post",
                async: false,
                data: {"blogid": blogid},
                dataType: "json",
                success: function (result) {
                    forwardblogcontent = "//@" + userna + ":" + result[0].BLOG_TEXT;
                }
            })
            $(".blogtextareappu").val(forwardblogcontent);
            $(".blogtextareappu").focus();
            $('.blogtextareappu').selectRange(0);

        } else {
            forward = blogid;//否则forward等于当前微博id
        }
        $('.emo').bind({
            click: function (event) {
                if (!$('#sinaEmotion').is(':visible')) {
                    $(this).sinaEmotion();
                    event.stopPropagation();
                }
            }
        });
        $(".puimg").click(function () {
            openImgUpload();
            $(".titlesec").text("转发只能添加一张图片哦~");
            forwardImgUpload();//图片上传
        });
        $(".pupublish").click(function () {
            event.preventDefault();
            if (num == 0) {//无图片视频提交
                var blogcontentpu = $(".blogtextareappu").val();
                $.ajax({
                    url: "/InsertBlogServlet",
                    type: "post",
                    data: {"blogcontent": blogcontentpu, "forward": forward,"userid":nowuserid},
                    success: function () {
                        layer.closeAll();
                        layer.msg('发布成功', {icon: 1});
                        $.ajax({
                            url: "/InsertForwardServlet",
                            type: "post",
                            data: {"blogid": blogid,"userid":nowuserid},//更改为sessionid
                            success: function (result) {
                                layer.closeAll();
                                layer.msg('发布成功', {icon: 1});
                                $('#home_blog_content_show').load('blogcontent.html');
                            }
                        })
                    }//,
                    // error: function () {
                    //     layer.closeAll();
                    //     layer.msg('发布成功', {icon: 1});
                    //     $('#home_blog_content_show').load('blogcontent.html');
                    // }
                })
            }
        });
    });
    //--------------收藏
    $("#result").on('click','.collect',function (e) {
        e.preventDefault();
        var $thisthis = $(this);
        var userid = nowuserid;
        var $nb666=$($(this.parentNode.parentNode.parentNode.parentNode).next());
        var blogid = $($(this).closest(".blogcontent_main")).attr("blogid");
        if (  $($(this.parentNode.parentNode.parentNode.parentNode).next()).is(':hidden')){
            layer.confirm('是否收藏此微博？', {
                btn: ['收藏','点错了'] //按钮
            }, function(){
                $.ajax({
                    url:"/SelectCollectBlogServlet",
                    type:"post",
                    data:{"blog_id":blogid ,"user_id":userid},
                    dataType:"json",
                    success:function (re) {
                        if (re == 0) {
                            $.ajax({
                                url:"/InsertCollectServlet",
                                type:"post",
                                data:{"blog_id":blogid,"user_id":userid},
                                dataType:"json",
                                success:function (ret) {
                                    if (ret == 1) {
                                        layer.msg('收藏成功', {icon: 1});
                                        $.ajax({
                                            url:"/ShowCollectByBlogIdServlet",
                                            type:"post",
                                            data:{"blog_id":blogid},
                                            dataType:"json",
                                            success:function (ret) {
                                                for (var qwe =0;qwe<ret.length;qwe++) {
                                                    var $shoucangnode = ('<li><div class="blogcontent_shoucang_demo"><img src="' + ret[qwe].HEAD_IMG + '" alt="" width="24px" height="24px"><a href="">' + ret[qwe].USER_NAME + '</a><span>：收藏了此微博</span></div></li>')
                                                    $nb666.find("ul").append($shoucangnode);
                                                    $nb666.show();
                                                }
                                                $.ajax({
                                                    url: "/BlogInfoNumByBlogIDServlet",
                                                    type: "post",
                                                    async:false,
                                                    data: {"blog_id": blogid},
                                                    dataType: "json",
                                                    success: function (result12) {
                                                        $thisthis.text('收藏('+result12[0].collectNum+')');
                                                        // new_main.children().eq(2).children().eq(3).children().children().eq(1).children().children().eq(1).text('('+result11[0].likeNum+')');
                                                    }
                                                })
                                            }
                                        });
                                    }
                                }
                            });
                        }else if (re == 1){
                            layer.msg('您已经收藏过了', {icon: 3});
                            $.ajax({
                                url:"/ShowCollectByBlogIdServlet",
                                type:"post",
                                data:{"blog_id":blogid},
                                dataType:"json",
                                success:function (ret) {
                                    for (var qwe =0;qwe<ret.length;qwe++) {
                                        var $shoucangnode = ('<li><div class="blogcontent_shoucang_demo"><img src="' + ret[qwe].HEAD_IMG + '" alt="" width="24px" height="24px"><a href="">' + ret[qwe].USER_NAME + '</a><span>：收藏了此微博</span></div></li>')
                                        $nb666.find("ul").append($shoucangnode);
                                        $nb666.show();
                                    }
                                }
                            });
                        }
                    }
                });


            }, function(){
                layer.msg('那就算了', {icon: 5});
            });}else{
            $nb666.hide();
            $nb666.find("ul").children().remove();
        }
    });
    //-----------------------评论
    $("#result").on('click', '.blogcontent_pinglun_submit', function () {
        var blogid2 = $($(this).closest(".blogcontent_main")).attr("blogid");
        var text1 = $($(this).parent().prev().children()).val();
        var pp = $(this);
        // alert(text1);
        $.ajax({
            url: '/InsertDiscussServlet',
            type: 'post',
            data: {"blogId": blogid2, "userId": nowuserid, "discussText": text1},
            dataType: 'json',
            success: function () {
                layer.msg("评论成功！", {icon: 1});
                $(".talk").trigger("click");
                $(".talk").trigger("click");
                pp.parent().prev().children().val("");
                $.ajax({
                    url: "/BlogInfoNumByBlogIDServlet",
                    type: "post",
                    async:false,
                    data: {"blog_id": blogid2},
                    dataType: "json",
                    success: function (result11) {
                        pp.closest(".blogcontent_main").find("span").eq(3).find("a").eq(0).text('评论('+result11[0].discussNum+')');
                    }
                })
            }
        });
    })

    //点开评论按钮，展示该条微博所有评论
    $("#result").on('click', '.talk', function (e) {
        // alert("nihao");
        e.preventDefault();
        var $pupupu = $($(this.parentNode.parentNode.parentNode.parentNode).next().next());
        $pupupu.find(".show_pinglun").children().remove();


        var blogid1 = $($(this).closest(".blogcontent_main")).attr("blogid");

        $.ajax({
            url: '/ShowDiscussServlet',
            type: 'post',
            data: {"blogId": blogid1},
            dataType: 'json',
            success: function (result) {
                for (var i = 0; i < result.length; i++) {
                    // alert(result[i].USER_NAME);
                    var $node = ('<li><div class="blogcontent_pinglun_demo"> <div class="blogcontent_pinglun_head"><img src="' + result[i].HEAD_IMG + '" alt="" width="24px" height="24px"></div> <div class="blogcontent_pinglun_neirong"><span style="width: 365px"><a  href="">' + result[i].USER_NAME + ' :</a><span>' + result[i].DISCUSS_TEXT + '</span></span></div> <div class="blogcontent_pinglun_huifu"><a usern='+result[i].USER_NAME+' class="blogcontent_huifu">回复</a></div></div></li>');
                    $pupupu.find(".show_pinglun").append($node);

                }

            }
        });
        if ($($(this.parentNode.parentNode.parentNode.parentNode).next().next()).is(':hidden')) {
            $($(this.parentNode.parentNode.parentNode.parentNode).next().next()).show();
        } else {
            $($(this.parentNode.parentNode.parentNode.parentNode).next().next()).hide();
        }
    });
    $("#result").on('click','.blogcontent_huifu',function () {
        var nn = $(this).attr("usern");
        // alert(nn);
        $($(this).closest(".show_pinglun")).prev().children().eq(0).children().val("@"+nn+":");

    })


    //-----------------------点赞
    $("#result").on('click','.like',function (e) {
        e.preventDefault();
        var userid = nowuserid;
        var $this =$(this);
        var $nb999=$($(this.parentNode.parentNode.parentNode.parentNode).next());
        var blogid = $($(this).closest(".blogcontent_main")).attr("blogid");
        $.ajax({
            url:"/insertBlogLikeServlet",
            type:"post",
            data:{"blog_id":blogid,"user_id":userid},
            dataType:"json",
            success:function (result) {
                if (result==1){
                    layer.msg('点赞成功', {icon: 1});
                    $this.find('img').attr('src','images/like.png');
                }else if(result == -1){
                    layer.msg('取消点赞成功', {icon: 5});
                    $this.find('img').attr('src','images/nolike.png');
                }
            }
        });

        // alert("dianza")
        //         // var str = $(this).find('img').attr("src");
        //         // if (str=="images/nolike.png"){
        //         //     $(this).find('img').attr('src','images/like.png');
        //         // }else{
        //         //     $(this).find('img').attr('src','images/nolike.png');
        //         // }
    });
    //-----------------------举报
    $("#result").on('click','.report',function (e){
        var blogid = $($(this).closest(".blogcontent_main")).attr("blogid");
        layer.confirm('是否举报此微博？', {
            btn: ['举报','点错了'] //按钮
        },function () {
            $.ajax({
                url:"/ReportServlet",
                type:"post",
                data:{"blogId":blogid},
                success:function (ret) {
                    layer.msg('举报成功', {icon: 1});
                }
            });
        },function () {
            layer.msg('那就算了', {icon: 5});
        })
    })
//    -----------------------------图片
    $("body").on("click",".img_lay",function () {
        var $id  = $(this).parent().attr("id");
        layer.photos({
            photos: '#'+$id,
            anim: 5//0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
        });
    })
    $("#result").on('click','.blogcontent_head_img',function () {
        var uid = $($(this).closest(".blogcontent_main")).attr("userid");
        $(this).attr("href","myZone.html?userid="+uid);
    })

})