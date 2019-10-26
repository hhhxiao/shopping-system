function isInteger(obj) {
    return typeof obj === 'number' && obj % 1 === 0
}
function isEmpty(obj) {
    return typeof obj == "undefined" || obj == null || obj.trim() === "";
}

$(document).ready(function () {
    let item;
    $.ajax({
        url: "/item/get",
        type: "get",
        contentType: "application/json",
        success:
            function (data) {
                item = data;
                console.log(data);
                $('#item-name').text(data.itemName);
                $('#item-factory').text(data.factory);
                $('#item-price').text(data.price);
                $('#item-sold').text(data.sold);
                $('#item-stock').text(data.stock);

            }
    });
    $(".ui.dropdown").dropdown();
    $('#buy').click(function () {
        var count = $('#count').val();


    });
});