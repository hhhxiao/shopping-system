function isInteger(obj) {
    return typeof obj === 'number' && obj % 1 === 0
}

function isEmpty(obj) {
    return typeof obj == "undefined" || obj == null || obj.trim() === "";
}

function getCurrentItemId() {
    const urlArr = window.location.href.split('?');
    const pathArr = urlArr[0].split('/');
    return pathArr[pathArr.length - 1]
}


$(document).ready(function () {
    const id = getCurrentItemId();
    console.log(id);
    let item;


    $.ajax({

        url: "/item/get-id",
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            'itemId': id,
        }),
        success:
            function (data) {
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
        console.log(count);
        $.ajax({
            url: "/buy",
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                'itemId': id,
                'soldNum': count
            }),
            success:
                function (data) {
                    if (data) {
                        alert("购买成功");
                    } else {
                        alert("购买失败");
                    }
                }
        });
    });
});