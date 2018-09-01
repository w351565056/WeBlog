
$(function () {
    $('#home_blog_content_show').load('blogcontent.html');
    $("#nav_search_blog span").click(function () {

        $.ajax({
            url:"/SearchBlogServlet",
            type:"post",
            dataType:"json",
            data:{"keyword":$("#nav_search_blog input").val()},
            success:function (listsearch){
                alert(listsearch);
                    alert(WEIBO + listsearch[2].BLOG_ID + YONGHU +listsearch[2].USER_ID )
            }
        });
    })

})


