



<html>
<head>
    <title>ActiveWidgets</title>
<script src="/grid/js/activewidgets/lib/aw.js"></script>
<link href="/grid/js/activewidgets/styles/xp/aw.css" rel="stylesheet"></link>
</head>
<body>
<script>

    // simple grid
    var obj = new AW.UI.Grid;
    obj.setCellText("cell");
    obj.setHeaderText("header");
    obj.setColumnCount(10);
    obj.setRowCount(10);
    document.write(obj);

    document.write("<p>---</p>");

    // extended grid
    var obj = new AW.Grid.Extended;
    obj.setCellText("cell");
    obj.setHeaderText("header");
    obj.setColumnCount(10);
    obj.setRowCount(10);
    obj.setHeaderCount(1); // two header lines
    obj.setFixedLeft(1); // fixed left column
    document.write(obj);

</script>

</body>
</html>