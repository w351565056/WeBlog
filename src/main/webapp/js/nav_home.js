
$(function () {
    $("#nav_search_blog span").click(function () {
        $.ajax({
            url:"/SearchBlogServlet",
            type:"post",
            dataType:"json",
            data:{"keyword":$("#nav_search_blog input").val()},
            success:function (list){
                alert(list);

                var $node = $('<div style="color: white">888888888888888888888888888</div>');
                $("#home_blog_content_show").append($node);

            }
        });
    })

})
$(document).ready(function(){
    $('#home_blog_content_show').load('blogcontent.html');
});
