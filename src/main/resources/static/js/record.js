function gene_html(record) {
    const  html = `  <tr>
            <td>${record.soldId}</td>
            <td>${record.userEmail}</td>
            <td>${record.itemId}</td>
            <td>18-3-23</td>
        </tr>`;
    return html;
}