$(document).ready(function () {

    var pattern = /^[a-z0-9_-]+@[a-z0-9-]+\.[a-z]{2,6}$/i;
    var mail = $('#email');


    $('#contact-form').validate({
        rules: {

            emailL:{
                requared: true,
                email: true
            },

            passwordL: {
                minlength: 8,
                required: true
            },

            email: {
                required: true,
                email: mail.blur(function(){
                    if(mail.val() != ''){
                        if(mail.val().search(pattern) == 0){
                           return true;
                        }else{
                          return   false;
                        }
                    }else{
                        return false;
                    }
                })
            },
            password: {
                minlength: 8,
                required: true
            },
            conf: {
                minlength: 8,
                equalTo : "#password"
            }
        },
        highlight: function (element) {
            $(element).closest('.control-group').removeClass('success').addClass('error');
        },
        success: function (element) {
            element.addClass('valid')
                .closest('.control-group').removeClass('error').addClass('success');
        }
    });

});