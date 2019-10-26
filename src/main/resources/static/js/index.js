function gene_card_html(item) {
    return `<div class="card">
<div class="image">
                <img src="../images/steve.jpg" alt="商品图片">
                </div>
                    <div class="content">
                        <h5 class="ui red header">${item.price}元</h5>
                        <h5 class="ui header"><a href="/id/${item.itemId}">${item.itemName}</a></h5>
                        ${item.factory}</div>
                        </div>`;
}

$(document).ready(function () {
    $.ajax({
        url: "/item/all",
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
                url: "/item/name/" + name,
                type: "get",
                contentType: "application/json",
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