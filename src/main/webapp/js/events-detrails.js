(function($) {


    var loc=location.href;
    var n1=loc.length;
    var n2=loc.indexOf("=");
    var id=decodeURI(loc.substr(n2+1, n1-n2));//从=号后面的内容
    //if(isNaN(id)) id = 0;
    console.log(id);

    $.ajax({
        url: 'event/findOne?id='+id,
        type: 'get',
        dataType: "text",
        success: function (data) {
            if (data) {
                json = $.parseJSON(data);
                show(json)

            } else {
                alert('获取资源失败');
            }
        }
    });

    function show(data) {

        //$('.content').text(data.body);
        $('.date').text(data.start);
        //$('.text').text(data.body);
        var $li = $(data.body);
        $("#postDetail").append($li);
        $('.list li:first-child span:last-child').text(data.price);
        $('.list li:nth-child(2) span:last-child').text(data.start);
        $('.list li:nth-child(3) span:last-child').text(data.lectures);
        $('.list li:nth-child(4) span:last-child').text(data.organizer);
        $('.list li:last-child span:last-child').text(data.address);
        
        document.getElementById('picture').src = data.picture;
        
    }

})(window.jQuery)