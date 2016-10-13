
var map;
function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var mapOptions = {
        center: new google.maps.LatLng(9.9940, 76.2920),
        zoom: 8,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(mapCanvas, mapOptions);
    google.maps.event.addListener(map, 'click', function (event) {
        var marker = new google.maps.Marker({
            position: event.latLng,
            draggable: true,
            animation: google.maps.Animation.DROP,
            map: map
        });

        google.maps.event.addListener(marker, 'click', function () {
            marker.setMap(null);
        });
        google.maps.event.addListener(marker, 'dragend', function (event) {
            $("#latitude").val(event.latLng.lat());
            $("#longitude").val(event.latLng.lng());
            console.log(event.latLng.lat());
        });
        $("#latitude").val(event.latLng.lat());
        $("#longitude").val(event.latLng.lng());
    });
}
google.maps.event.addDomListener(window, 'load', initialize);

tjq(document).ready(function () {
    tjq(".place-link").click(function () {
        // alert("zdaff");
        console.log("sdasd");
        initialize();
        // google.maps.event.trigger(map, 'resize');
    });


    tjq('.datepicker').datepicker({
        format: 'dd/mm/yyyy',
        startDate: '-3d'
    });

    tjq(".user-data").click(function () {
        var id = $(this).attr("data-id");
        var type = $(this).attr("data-type");

        $.ajax({
            method: "POST",
            url: "ajax/getuserdata.php",
            data: {id: id,
                type: type}
        }).done(function (msg) {
            $("#modal_body").html(msg);
            $("#userModel").modal();
        }).fail(function () {
            alert("Request Failed");
        });
    });

    tjq("#district").on('change', function () {
        $.ajax({
            method: "POST",
            url: "ajax/gettaluk.php",
            data: {district: $(this).val()}
        }).done(function (msg) {
            $("#taluk").html(msg);
        }).fail(function () {
            alert("Request Failed");
        });
    });

    tjq("#btn_addimage").click(function (e) {
        e.preventDefault();
//                    $("#new_image_group").append("<div class=\"col-md-10\"><input type=\"file\" class=\"form-control\" id=\"images\" name=\"images[]\" required/></div>");
    });

    tjq('#package_form').on('submit', function (e) {
        e.preventDefault();

        $.ajax({
            type: 'post',
            url: $(this).attr('action'),
            data: $(this).serialize(),
            success: function (msg) {
                $("#page1").hide();
                $("#page2").html(msg);
            }
        });

    });
})

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}