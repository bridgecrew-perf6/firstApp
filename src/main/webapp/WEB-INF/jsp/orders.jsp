<!DOCTYPE html>

<html lang='en'>
<head>
  <meta charset='utf-8' />
  <link href='../../resources/js/fullcalendar-5/lib/main.css' rel='stylesheet' />
  <script type="text/javascript" src="../../resources/js/fullcalendar-5/lib/main.js"></script>

<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {

      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,listYear'
      },

      events: 'api/orders',

      displayEventTime: true, // don't show the time column in list view

      eventClick: function(info) {
        // opens events in a popup window
        var popup = window.open("", 'order','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=500');

        popup.focus();

        let html = `<html lang='en'><head><meta charset='utf-8' />
    <link rel="stylesheet" href="../../resources/css/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>
</head><body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12">
            <div class="tab-pane">
                <div class="card-header"><b>Order by ` + info.event.extendedProps.who +`</b></div>
                <div class="text-body">
                    <table class="table table-striped">
                        <th>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>dishName</th>
                                <th>Amount</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Banana Kex</td>
                                <td>` + info.event.extendedProps.bananaKexCount + `</td>
                            </tr>
                            <tr>
                                <td>Carrot Kex</td>
                                <td>` + info.event.extendedProps.carrotKexCount + `</td>
                            </tr><tr>
                                <td>Vegan Kex</td>
                                <td>` + info.event.extendedProps.intvegaanKexCount + `</td>
                            </tr><tr>
                                <td>Banana Pudding</td>
                                <td>` + info.event.extendedProps.banabapudding + `</td>
                            </tr><tr>
                                <td>Canele</td>
                                <td>` + info.event.extendedProps.canele + `</td>
                            </tr><tr>
                                <td>Biscotti, ps</td>
                                <td>` + info.event.extendedProps.biscotti + `</td>
                            </tr><tr>
                                <td>Chocolate Cookies, ps</td>
                                <td>` + info.event.extendedProps.chocolatecookies + `</td>
                            </tr><tr>
                                <td>Cheese pancakes</td>
                                <td>` + info.event.extendedProps.syrniki + `</td>
                            </tr><tr>
                                <td>Tofu Bowl</td>
                                <td>` + info.event.extendedProps.tofuboul + `</td>
                            </tr><tr>
                                <td>Salmon Bowl</td>
                                <td>` + info.event.extendedProps.salmonboul + `</td>
                            </tr><tr>
                                <td>Toscana Salad</td>
                                <td>` + info.event.extendedProps.toskanasalad + `</td>
                            </tr><tr>
                                <td>Kaprese Salad</td>
                                <td>` + info.event.extendedProps.kapresesalad + `</td>
                            </tr><tr>
                                <td>Mozzarella Croissant</td>
                                <td>` + info.event.extendedProps.mozzarellacroissant + `</td>
                            </tr><tr>
                                <td>Salmon Croissant</td>
                                <td>` + info.event.extendedProps.salmoncroissant + `</td>
                            </tr><tr>
                                <td>Chicken Croissant</td>
                                <td>` + info.event.extendedProps.chickencroissant + `</td>
                            </tr><tr>
                                <td>Chicken-Curry Sandwich</td>
                                <td>` + info.event.extendedProps.chickencurrysandwich + `</td>
                            </tr><tr>
                                <td>Italy Sandwich</td>
                                <td>` + info.event.extendedProps.italysandwich + `</td>
                            </tr><tr>
                                <td>England Sandwich</td>
                                <td>` + info.event.extendedProps.englandsandwich + `</td>
                            </tr><tr>
                                <td>Chicken with bacon Ciabatta</td>
                                <td>` + info.event.extendedProps.chickenciabatta + `</td>
                            </tr><tr>
                                <td>Ham and Chesse Ciabatta</td>
                                <td>` + info.event.extendedProps.hamchiabatta + `</td>
                            </tr><tr>
                                <td>Blue Chesse Ciabatta</td>
                                <td>` + info.event.extendedProps.bluecheesechiabatta + `</td>
                            </tr><tr>
                                <td>Sweet Potato Soup</td>
                                <td>` + info.event.extendedProps.sweetpotatosoup + `</td>
                            </tr><tr>
                                <td>Pumpkin Soup</td>
                                <td>` + info.event.extendedProps.pumpkinsoup + `</td>
                            </tr><tr>
                                <td>Broccoli Soup</td>
                                <td>` + info.event.extendedProps.broccolisoup + `</td>
                            </tr><tr>
                                <td>Sourcream</td>
                                <td>` + info.event.extendedProps.sourcream + `</td>
                            </tr><tr>
                                <td>Salmon sauce</td>
                                <td>` + info.event.extendedProps.salmonsauce + `</td>
                            </tr><tr>
                                <td>Crackers</td>
                                <td>` + info.event.extendedProps.crackers + `</td>
                            </tr>
                            </tbody>
                        </table>
                        </th>
                    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div></body></html>`;
        popup.document.body.innerHTML = html;

        // arg.jsEvent.preventDefault() // don't navigate in main tab
      },
    });
    calendar.render();
  });

</script>
  <style>

    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>

</head>
<body>
<div id='calendar'></div>
</body>
</html>
