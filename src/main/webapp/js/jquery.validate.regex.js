
    jQuery.validator.addMethod("regex", //addMethod第1个参数:方法名称
        function (value, element, params) {//addMethod第2个参数:验证方法，
            //验证方法参数（被验证元素的值，被验证元素，参数）
            var exp = new RegExp(params);//实例化正则对象，参数为用户传入的正则表达式
            return exp.test(value);//测试是否匹配
        }, "格式错误");