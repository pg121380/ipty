(function($) {
	var page = 0;
    var rows = 9;

    getData(page, rows);

    function getData(page, rows) {
        $.ajax({
            url: 'event/findPage?page=' + (page+1) + '&rows=' + rows + "&t=" + new Date(),
            type: 'get',
            dataType: "text",
            success: function (data) {
                if (data) {
                    json = $.parseJSON(data);
                    showData(json['rows']);
                } else {
                    alert('获取资源失败');
                }
            }
        });
    }

    $('.link-btn').click(function(){
        getData(page, rows);
    });

    function showData(arr) {

        for(var i = 0, c = 1; i < rows; i++, c++){
            if(c === 4)
                c = 1;
            var string = 'bg-color-' + c.toString();  // 背景颜色

            var sdlkf = arr[i].sdfsdf;
            var categories = arr[i].categories;
            var id = arr[i].id;
            var price = arr[i].price;
            var start = new Date(arr[i].start);
            var lectures = arr[i].lectures;
            var organizer = arr[i].organizer;    // 标题
            var address = arr[i].address;
            var body = arr[i].body;
            var picture = arr[i].picture;

            parentdiv = $('.row');

            var div = '<div id="'+ id +'" class="aaa col-md-4 col-sm-6 col-xsw-12 item wow fadeIn" data-wow-duration="2s" data-wow-delay="0.5s" data-wow-offset="0" style="visibility: visible; animation-duration: 2s; animation-delay: 0.5s; animation-name: fadeIn;">\n' +
                '                <div class="img-holder">\n' +
                '                    <figure><a href="#"><img id="'+ id +'" src="' + picture + '"onmouseup="getEventDetrails(this.id)" alt="Awesome Image"></a></figure>\n' +
                '                    <div class="content '+ string +'">\n' +
                '                        <div class="inner-box">\n' +
                '                            <div class="btn-box">\n' +
                '                                <div class="count">' + start.getDate() + '</div>\n' +
                '                                <div class="month">' + (start.getMonth() + 1) + '</div>\n' +
                '                            </div>\n' +
                '                            <h4><a href="#">' + categories + '</a></h4>\n' +
//                '                            <p><span class="fa fa-clock-o"></span>' + start.getHours() + ' : ' + start.getMinutes() + '</p>\n' +
                '                            <p><span class="fa fa-map-marker"></span>'+ address + '</p>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>';

            parentdiv.append(div);
        }
    }

    getEventDetrails = function (id){
        location.href="events-detrails.html?"+"id=" + id;
    };

})(window.jQuery)