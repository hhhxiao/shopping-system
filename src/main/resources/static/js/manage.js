function item_html(item) {
    return `<tr id="${item.itemId}">
            <td>${item.itemId}</td>
            <td>${item.itemName}</td>
            <td>${item.price}</td>
            <td>${item.factory}</td>
            <td>${item.sold}</td>
            <td>
                <div class="ui input stock-modify">
                <input type="text"   class="${item.itemId}" value="${item.stock}">
                <button class="ui button icon stock-modify-button" onclick="stock(${item.itemId})">
                <i class="icon check"></i>
                </button>
                </div> 
            </td>
            <td>
                <button class="ui icon button delete-button" onclick="manage(${item.itemId})" >
                <i class="trash icon"></i>
                </button>
            </td>
        </tr>`
}


function isEmpty(obj) {
    return typeof obj == "undefined" || obj == null || obj.trim() === "";
}


//修改库存
function stock(id) {
    alert("修改成功");
    $.ajax({
        url: "/item/stock-modify",
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            'itemId': id,
            'stock': $("."+id).val(),
        }),
        success:
            function (data) {
                alert("修改成功" + id);
            }
    });
}

//删除物品（下架）
function manage(id) {
    $.ajax({
        url: "/item/delete",
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            'itemId': id,
        }),
        success:
            function (data) {
                if(data){
                    $("#"+id).remove();
                    alert("删除成功" + id);
                }else{
                    alert("删除出错");
                }
            }
    });
}

//添加物品
$(document).ready(function () {
    let b = true;
    $('#add-item').hide();
    $('#add').click(function () {
        if (b) {
            $('#add-item').show();
            $(this).text("退出编辑");
            b = false;
        } else {
            $('#add-item').hide();
            $('#add').text("添加物品");
            b = true;
        }
    });


    $('#logout').click(function () {
        window.location.href = "/logout";
    });
    $('#record').click(function () {
        window.location.href = "/record";
    });

    $('#index').click(function () {
        window.location.href="/index";
    });


    //添加物品
    $('#item-add-submit').click(function () {
        //todo
        const item_name = $('#item-name').val();
        const item_factory = $('#item-factory').val();
        const item_price = $('#item-price').val();
        const item_stock = $('#item-stock').val();
        if (isEmpty(item_name) || isEmpty(item_factory) || isEmpty(item_price) || isEmpty(item_stock)) {
            alert("商品信息没有填写完整");
        } else {
            $.ajax({
                url: "/item/add",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify({
                    'itemName': item_name,
                    'price': item_price,
                    'factory': item_factory,
                    'stock': item_stock
                }),
                success:
                    function (data) {
                        console.log(data);
                        if (data) {
                            alert("商品添加成功");
                        } else {
                            alert("商品添加失败");
                        }
                    }
            });
        }
    });

    $.ajax({
        url: "/item/all",
        type: "get",
        contentType: "application/json",
        success:
            function (data) {
                data.forEach(function (item) {
                    console.log(item);
                    $('#table-body').append(item_html(item));
                    $('.delete-button').hide();
                    $('#last-col').hide();
                    $('.stock').attr('readonly', 'readonly');
                    $('.stock-modify-button').hide();
                });
            }
    },);
    let a = true;
    $('#delete').click(function () {
        if (a) {
            $('.stock-modify').addClass('action');
            $('.delete-button').show();
            $('#last-col').show();
            $('.stock').removeAttr('readonly', 'readonly');
            $('.stock-modify-button').show();
            $('#delete').text('退出编辑');
            a = false;
        } else {
            $('.stock-modify').removeClass('action');
            $('#last-col').hide();
            $('.delete-button').hide();
            $('.stock-modify-button').hide();
            $('.stock').attr('readonly', 'readonly');
            a = true;
            $('#delete').text('删除物品');
        }
    });
    $("")
});