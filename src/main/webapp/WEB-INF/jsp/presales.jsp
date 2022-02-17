<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>PRESALES</title>
  <style>
    .parent {
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      left: 0;
      overflow: auto;
    }
    .data {
      width: 250px;
      height: 250px;
      position: absolute;
      top: 50%;
      left: 50%;
      margin: -125px 0 0 -125px;
    }
  </style>
</head>
<body>
<div class="parent">
  <div class="data">
    <form action="sales" method="post">
      <table >
        <th><input type="date"  name="beginDate" ></th>
        <th><input type="date"  name="endDate" ></th>
      </table>
      <input type="submit"  value="create">
    </form>
  </div>
</div>
</body>
