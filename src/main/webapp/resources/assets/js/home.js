$(document).ready(function () {



    $('#contact-form').validate({
        lang: 'ru',
        rules: {

            email: {
                required: true,
                email: true
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

    $('#contact-formL').validate({
        rules: {

            emailL:{
                requared: true,
                email: true
            },

            password: {
                minlength: 8,
                required: true
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