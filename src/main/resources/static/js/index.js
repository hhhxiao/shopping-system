function gene_card_html(item) {
    return `<div class="card">
<div class="image">
                <img src="../images/steve.jpg" alt="商品图片">
                </div>
                    <div class="content">
                        <h5 class="ui red header">${item.price}元</h5>
                        <h5 class="ui header"><a href="/item/${item.itemId}">${item.itemName}</a></h5>
                        ${item.manufact}</div>
                        </div>`;
}

$(document).ready(function () {
    $.ajax({
        url: "/test/get-item",
        type: "get",
        contentType: "application/json",
        success:
            function (data) {
                data.forEach(function (item) {
                    $('#item-context').append(gene_card_html(item));
                });
            }
    });


    $('#search').bind('keypress', function (event) {
        if (event.keyCode == "13") {
            var name = $('#search').val();
            console.log(name);
            $.ajax({
                url: "/test/search",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify({
                    'itemName': name,
                }),
                success:
                    function (data) {
                        let html = "";
                        data.forEach(function (item) {
                            html += gene_card_html(item);
                        });
                        $('#item-context').html(html);
                    }
            });
        }
    });

    $(".ui.dropdown").dropdown();
});