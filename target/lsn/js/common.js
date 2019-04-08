function get_www_url(){
    var url = "/lsn";
    return url;
}

$(function(){
    $.ajax({
        url : get_www_url()+"/frame/top",
        type : 'POST',
        success : function(data) {
            $("#top").html(data);
        }
    });


})