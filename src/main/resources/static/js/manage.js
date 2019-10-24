function item_html(item) {
    return `<tr>
            <td>${item.itemId}</td>
            <td>${item.itemName}</td>
            <td>${item.price}</td>
            <td>${item.manufact}</td>
            <td>${item.sold}</td>
            <td>
                <div class="ui input stock-modify">
                <input type="text"   class="stock" value="${item.stock}">
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


function stock(id) {
    alert("修改成功");
    $.ajax({
        url: "/test/stock-modify",
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            'itemId': id,
        }),
        success:
            function (data) {
                alert("修改成功" + id);
            }
    });
}

function manage(id) {
    alert("删除成功" + id);
    $.ajax({
        url: "/test/delete",
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            'itemId': id,
        }),
        success:
            function (data) {
                alert("删除成功" + id);
            }
    });
}

$(document).ready(function () {
    let b = true;
    $('#add-item').hide();
    $('#add').click(function () {
        if (b) {
            $('#add-item').show();
            $(this).val("退出编辑");
            b = false;
        } else {
            $('#add-item').hide();
            $('#add').val("添加物品");
            b = true;
        }
    });

    $('#item-add-submit').click(function () {
        //todo
        alert('物品已经添加至仓库');
    });

    $.ajax({
        url: "/test/get-item",
        type: "get",
        contentType: "application/json",
        success:
            function (data) {
                data.forEach(function (item) {
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
            $('.delete-button').show();
            $('#last-col').show();
            $('.stock').removeAttr('readonly', 'readonly');
            $('.stock-modify-button').show();
            $('#delete').val('退出编辑');
            a = false;
        } else {
            $('#last-col').hide();
            $('.delete-button').hide();
            $('.stock-modify-button').hide();
            $('.stock').attr('readonly', 'readonly');
            a = true;
            $('#delete').val('删除物品');
        }
    });
});