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
    var imgopen = null;//图片界面打开的标志
    var videoopen = null;//视频界面打开的标志
    var regImg = /image/;
    var regVideo = /video/;
    var regMp3 = /audio/;

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

    function openVideoPreview() {
        layer.close(videoopen);
        videoopen = layer.open({
            type: 1,
            title: false,
            shade: 0, //遮罩透明度,
            area: '392px',
            offset: ['240px', '425px'],
            anim: 5,
            content: '<div class="insert_video">\n' +
            '    <div class="title">上传普通视频</div>\n' +
            '    <div class="titlesec" style="font-size:14px;font-weight: 700;margin-top: -10px"><img src="images/success.png" width="16px" style="margin-right: 10px">上传成功</div>\n' +
            '    <div class="videopreview">\n' +
            '    </div>\n' +
            '</div>',
            cancel: function () {
                videoopen = null;
            }
        })
    }

    function imgUpload() {
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
                    // var $img = $("<img>").attr("src", url).css({
                    //     "width": "80px",
                    //     "height": "120px",
                    //     "vertical-align": "unset"
                    // })
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
                        if (num == 8) {
                            var newadd = $('<li id="add" class="add"><a></a></li>');
                            newadd.click(function () {
                                $("#fileupload").trigger("click");
                            })
                            $(".effects").append(newadd);
                        }
                    });

                    if (num < 9) {
                        //小于9张则加入新的添加图片按钮并赋予选择图片的事件
                        var newadd = $('<li id="add" class="add"><a></a></li>');
                        newadd.click(function () {
                            $("#fileupload").trigger("click");
                        })
                        $(".effects").append(newadd);
                    }
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

    }//图片上传

    function videoUpload() {
        $("#videoupload").trigger("click");
        //video上传
        $('.videoupload').fileupload({ //(该方法必须写在这里面)为发布按钮绑定了上传视频的事件
            url: "/uploadFile",
            Type: 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
            dataType: 'json',//服务器返回的数据类型

            //add函数为选择文件后执行的操作
            add: function (e, data) {
                if (!(regVideo.test(data.files[0].type)||regMp3.test(data.files[0].type))) {
                     layer.msg('只能上传视频或音乐哦', {icon: 0});
                 } else {
                    num++;
                    data.submit();
                }
            },
            //done函数为上传成功后执行的操作
            done: function (e, ret) {
                if (ret.result.errno == 0) { //视频上传成功
                    var videopath = new Array();
                    videopath[0] = ret.result.data[0];
                    openVideoPreview();
                    // layer.msg('上传成功', {icon: 1});
                    $(".videopreview").append('<embed class="embed_preview" src=' + videopath[0] + '>')
                    $(".pupublish").click(function () {
                        var blogcontentpu = $(".blogtextareappu").val();
                        event.preventDefault();//因为有form元素，所以要阻止表单的默认提交，不然大文件传不完
                        $.ajax({
                            url: "/InsertBlogServlet",
                            type: "post",
                            data: {
                                "blogcontent": blogcontentpu,
                                "imgpath": JSON.stringify(videopath),
                                "forward": forward,
                                "userid":nowuserid
                            },
                            success: function () {
                                layer.closeAll();
                                layer.msg('发布成功', {icon: 1});
                                videoopen=null;
                                imgopen=null;
                                $('#home_blog_content_show').load('blogcontent.html');
                            }
                        })
                    });
                } else {
                    layer.msg('上传失败', {icon: 2});
                }

            },
        });
    }//视频上传

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

    //--------------发布
    $("#btn").click(function () { //发布微博
        openBlogPublish();
        layer.title("有什么新鲜事想告诉大家？", index);
        $(".puvideo").css("display", "inline");
        $(".pupublish").text("发布");
        checkInput();
        $('.emo').bind({
            click: function (event) {
                if (!$('#sinaEmotion').is(':visible')) {
                    $(this).sinaEmotion();
                    event.stopPropagation();
                }
            }
        });
        $(".puimg").click(function () {
            if (videoopen == null) {//视频界面未打开
                openImgUpload();
                $(".titlesec").html('共<span class="nownum">0</span>张，还能上传<span class="remainnum">9</span>张');
                imgUpload();//图片上传
            } else {
                layer.confirm('确定放弃上传视频吗？', {
                    btn: ['确定', '取消']
                }, function () {
                    layer.close(videoopen);
                    videoopen = null;
                    layer.close(layer.index);
                    openImgUpload();
                    imgUpload();
                }, function () {
                    //do nothing
                });
            }
        });
        $(".puvideo").click(function () {
            if (imgopen == null) { //图片上传界面未打开
                videoUpload();
            } else {
                layer.confirm('确定放弃上传图片吗？', {
                    btn: ['确定', '取消']
                }, function () {
                    layer.close(imgopen);
                    imgopen = null;
                    layer.close(layer.index);
                    videoUpload();
                }, function () {
                    //do nothing
                });
            }
        });
        $(".pupublish").click(function () {
            event.preventDefault();
            if (num == 0) {//无图片视频提交
                var blogcontentpu = $(".blogtextareappu").val();
                $.ajax({
                    url: "/InsertBlogServlet",
                    type: "post",
                    data: {"blogcontent": blogcontentpu, "forward": forward,"userid":nowuserid},
                    dataType: "text",
                    success: function () {
                        layer.closeAll();
                        layer.msg('发布成功', {icon: 1});
                        $('#home_blog_content_show').load('blogcontent.html');
                    }
                });
            }
        });

    });

    })
