//Добавление в базу

$(document).ready(function () {
    $('#btn').click(function () {
        var data = $('#addContract').serializeArray();
        data.push({name: "fileName", value: fileName});
        $.ajax({
            type: 'POST',
            data: data,
            url: 'Main',
            dataType: 'text',
            success: function(resp){
                if(!(resp == "")){alert(resp);}
            }
        });
    });

    $('#user_reg_btn').click(function () {
        var data = $('#user_form').serialize();
        $.ajax({
            type: 'POST',
            data: data,
            url: 'Registration',
            dataType: 'text',
            success: function(resp){
                if(!(resp == "")){alert(resp);}
            }
        });
    });

    $('#clientName').keyup(getClientName('#clientName'));
    $('#criteriaName').keyup(getClientName('#criteriaName'));
    //Получение из базы всех значений
     function viewContracts (page){
        var data = $('#criteria').serializeArray();
        data.push({name: 'criteriaPage',  value: page});
        $.ajax({
            data: data,
            type: 'GET',
            url: 'View',
            dataType: 'html',
            success: function(resp){
                $('#result').html(resp);
                $('.pageNum').on('click',  function(){viewContracts(this.value)});
                $('.criteries').on('change',  function(){viewContracts()});
            }
        });
    };
    viewContracts ();
});


function getClientName(id) {
    $(id).autocomplete({
        source : function(request, response) {
            if($(id).val().length >= '3' ){
            $.ajax({
                url : "viewclients",
                type : "GET",
                data : {
                    term : request.term
                },
                dataType : "json",
                success : function(data) {
                    response(data);
                }
            });
        }}
    });
}

//Загрузка файлов
var fileName;
function upload() {
    var file_data = $("#file").prop("files")[0];
    var form_data = new FormData();
    form_data.append("file", file_data)
    $.ajax({
        type: 'POST',
        url: 'Uploader',
        data: form_data,
        dataType: 'script',
        cache: false,
        contentType: false,
        processData: false,
        success: function(resp){
            fileName = resp;
        }
    });
}