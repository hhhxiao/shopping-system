function gene_html(record) {
    const html = `  <tr>
            <td>${record.soldId}</td>
            <td>${record.userEmail}</td>
            <td><a href='/id/${record.itemId}'> ${record.itemId}</td>
            <td>${record.soldTime}</td>
            <td>${record.soldNum}</td>
        </tr>`;
    return html;
}

$(document).ready(function () {

    $('#logout').click(function () {
        window.location.href = "/logout";
    });

    $.ajax({
        url: "/get-record",
        type: "get",
        contentType: "application/json",
        success:
            function (data) {
                console.log(data);
                data.forEach(function (item) {
                    $('#record-body').append(gene_html(item));
                });
            }

    });
});