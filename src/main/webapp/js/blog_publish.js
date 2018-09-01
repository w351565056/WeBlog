$(function () {
    var num = 0;
    var imgpath=new Array();
    var index=0;
    function openBlogPublish() {
        layer.open({
            type: 1,
            area: ['500px', '240px'],
            title: '有什么新鲜事想告诉大家',
            shade: 0.3, //遮罩透明度,
            offset: ['10px', '400px'],
            closeBtn:1,
            anim: 5,
            content: '<form enctype="multipart/form-data">'+'<div id="layer-body">' +
            '<div class="layer-body-center">' +
            '<textarea name="desc" placeholder="说点儿什么吧" class="blogtext layui-textarea text"></textarea>' +
            '</div>' +
            '<div class="layer-body-footer">' +
            '<span class="emo layui-icon layui-icon-face-surprised smile"></span>' +
            '<span class="img layui-icon layui-icon-picture pic"></span>' +
            '<span class="video layui-icon layui-icon-video vid"></span>' +
            '<button class="publish layui-btn layui-btn-warm btn-fabu">发布</button>' +
            '</div>' +'<input id="videoupload" class="videoupload" type="file" name="files" multiple="multiple" style="display:none">'+
            '</div>'+'</form>'

        })
    }
    function openImgUpload() {
        layer.open({
            type: 1,
            title: false,
            shade: 0, //遮罩透明度,
            offset: ['240px', '425px'],
            anim: 5,
            content:'<div class="insert_img">\n' +
            '    <div class="title">本地上传</div>\n' +
            '    <div class="titlesec">共<span class="nownum">0</span>张，还能上传<span class="remainnum">9</span>张</div>\n' +
            '    <div class="attention_button ">\n' +
            '        <a>\n' +
            '            <span class="attention_add">+</span>\n' +
            '            <span  class="attention_text">标签</span>\n' +
            '        </a>\n' +
            '    </div>\n' +
            '    <ul class="add_area">\n' +
            '        <li  class="add"><a  class="add_a"></a></li>\n' +
            '\n' +
            '    </ul>\n' +
            '    <input id="fileupload" class="fileupload" type="file" name="files" multiple="multiple" style="display: none">\n' +
            '</div>'

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
                num++;
                $(".nownum").text(num);
                $(".remainnum").text(9 - num);
                //获取图片路径并显示预览
                var url = getUrl(data.files[0]);
                var $img = $("<img>").attr("src", url).css({"width": "80px", "height": "120px","vertical-align":"unset"})
                $(".add:last-child").append($img);
                //预览之后解除选择图片的事件绑定
                $(".add").unbind();
                //增加新的操作
                // $(".add").hover(function () {
                //     $(this).css("background-color","#666666");
                // })
                $(".add").click(function () {
                    $(this).remove();
                    data=null;
                    num--;
                    $(".nownum").text(num);
                    $(".remainnum").text(9 - num);
                    if (num == 8) {
                        var newadd = $('<li id="add" class="add"><a></a></li>');
                        newadd.click(function () {
                            $("#fileupload").trigger("click");
                        })
                        $(".add_area").append(newadd);
                    }
                });

                if (num < 9) {
                    //小于9张则加入新的添加图片按钮并赋予选择图片的事件
                    var newadd = $('<li id="add" class="add"><a></a></li>');
                    newadd.click(function () {
                        $("#fileupload").trigger("click");
                    })
                    $(".add_area").append(newadd);
                }
                //绑定上传提交事件
                $(".publish").click(function () {
                    data.submit();
                    event.preventDefault();
                });
            },
            //done函数为上传成功后执行的操作
            done: function (e, ret) {
                if (ret.result.errno == 0) {
                    imgpath[index]=ret.result.data[0];
                    index++;
                    num--;
                } else {
                    alert("上传失败");
                }if(num==0){//图片上传完毕提交文本内容和图片路径
                    var blogcontent=$(".blogtext").val();
                    $.ajax({
                        url:"/InsertBlogServlet",
                        type:"post",
                        data:{"blogcontent":blogcontent,"imgpath":JSON.stringify(imgpath)},
                        success:function () {
                            layer.closeAll();
                        }
                    })
                }
            },
        });

    }
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

    $("#btn").click(function () { //发布微博
        openBlogPublish();
        $('.emo').bind({
            click: function(event){
                if(! $('#sinaEmotion').is(':visible')){
                    $(this).sinaEmotion();
                    event.stopPropagation();
                }
            }
        });
        $(".img").click(function () {
            openImgUpload();
            imgUpload();//为发布按钮绑定了上传图片的事件
        });
        $(".video").click(function () {
            $("#videoupload").trigger("click");
            //video上传
            $('.videoupload').fileupload({ //(该方法必须写在这里面)为发布按钮绑定了上传视频的事件
                url: "/uploadFile",
                Type: 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
                dataType: 'json',//服务器返回的数据类型
                // singleFileUploads: false,//不设置多个文件循环提交，设置后一起提交

                //add函数为选择文件后执行的操作
                add: function (e, data) {
                    num++;
                    //绑定上传提交事件
                    $(".publish").click(function () {
                        data.submit();
                        event.preventDefault();//因为有form元素，所以要阻止表单的默认提交，不然大文件传不完

                    });
                },
                //done函数为上传成功后执行的操作
                done: function (e, ret) {
                    if (ret.result.errno == 0) { //视频上传成功
                        var videopath=new Array();
                        var blogcontent=$(".blogtext").val();
                        videopath[0]=ret.result.data[0];
                        $.ajax({
                            url:"/InsertBlogServlet",
                            type:"post",
                            data:{"blogcontent":blogcontent,"imgpath":JSON.stringify(videopath)},
                            success:function () {
                                layer.closeAll();
                            }
                        })
                    } else {
                        alert("上传失败");
                    }

                },
            });
        });
        $(".publish").click(function () {
            if(num==0){//无图片视频提交
                var blogcontent=$(".blogtext").val();
                $.ajax({
                    url:"/InsertBlogServlet",
                    type:"post",
                    data:{"blogcontent":blogcontent},
                    success:function () {
                        layer.closeAll();
                    }
                })
            }
        });
    });
    $("#result").on("click",".forward",function () { //转发微博
       alert($(this).closest($(".blogcontent_main")).attr("blogid"));
       alert($(this).closest($(".blogcontent_main")).attr("userid"));
       alert($(this).closest($(".blogcontent_main")).attr("userna"));
        openBlogPublish();
        //获取用户名，微博内容，微博id
        $('.emo').bind({
            click: function(event){
                if(! $('#sinaEmotion').is(':visible')){
                    $(this).sinaEmotion();
                    event.stopPropagation();
                }
            }
        });
        $(".img").click(function () {
            openImgUpload();
            imgUpload();//为发布按钮绑定了上传图片的事件
        });
        $(".video").click(function () {
            $("#videoupload").trigger("click");
            //video上传
            $('.videoupload').fileupload({ //(该方法必须写在这里面)为发布按钮绑定了上传视频的事件
                url: "/uploadFile",
                Type: 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
                dataType: 'json',//服务器返回的数据类型
                // singleFileUploads: false,//不设置多个文件循环提交，设置后一起提交

                //add函数为选择文件后执行的操作
                add: function (e, data) {
                    num++;
                    //绑定上传提交事件
                    $(".publish").click(function () {
                        data.submit();
                        event.preventDefault();//因为有form元素，所以要阻止表单的默认提交，不然大文件传不完

                    });
                },
                //done函数为上传成功后执行的操作
                done: function (e, ret) {
                    if (ret.result.errno == 0) { //视频上传成功
                        var videopath=new Array();
                        var blogcontent=$(".blogtext").val();
                        videopath[0]=ret.result.data[0];
                        $.ajax({
                            url:"/InsertBlogServlet",
                            type:"post",
                            data:{"blogcontent":blogcontent,"imgpath":JSON.stringify(videopath)},
                            success:function () {
                                layer.closeAll();
                            }
                        })
                    } else {
                        alert("上传失败");
                    }

                },
            });
        });
        $(".publish").click(function () {
            if(num==0){//无图片视频提交
                var blogcontent=$(".blogtext").val();
                $.ajax({
                    url:"/InsertBlogServlet",
                    type:"post",
                    data:{"blogcontent":blogcontent},
                    success:function () {
                        layer.closeAll();
                    }
                })
            }
        });
    });



})