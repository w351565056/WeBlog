
$(function () {


    $("#nav_search_blog span").click(function () {

        $("#home_blog_content_show").load("blogcontentsearchblog.html");
    })

    //根据评论数，转发数，获得点赞数 排序并显示微博内容
    //  请求url都为： /SearchByLikeServlet
    // data 为：data:{"keywordlike":"点赞"}、data:{"keywordforward":"转发"}、data:{"keyworddiscuss":"评论"}

    $('#home_blog_content_show').load('blogcontent.html');
})


