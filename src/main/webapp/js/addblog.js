$(document).ready(function () {
    
//    $('#addTag').click(function(event){
//        event.preventDefault();
//        $.ajax({
//            type: 'PUT',
//            url: 'hashTag',
//            data: JSON.stringify({
//                hashtag: $('#hashTag').val()
//            }),
//            headers:{
//                'Accept': 'application/json',
//                'Content-Type': 'application/json'
//            },
//            'dataType': 'json'
//        }).success(function (data, status){
//            $('#hashTag').val('');
//        });
//    });
    $('#addTag').click(function(event){
        document.getElementById("hashtags").value = 
                (document.getElementById("field1").value + "," + document.getElementById("hashtags").value);
        document.getElementById("field1").value = '';
    });
    
    $('#removeTags').click(function(event){
        document.getElementById("hashtags").value = '';
    });
    
    $('#cancel').click(function(event){
        window.location.replace('mainAjaxPage');
    })
    
    $('#save').click(function(event){
        window.location.replace('Admin2');
    })
    


});



