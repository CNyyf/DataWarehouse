/**
 * Created by AMXPC on 2016/12/31.
 */
function clock(a, b, c, d) {
    $(document).ready(function () {
        if (a < c) {
            $("#dwclock").css("color", "#449d44");
            $("#hiveclock").css("color", "#d2322d");
        }
        else if (a == c){
            if(b < d) {
                $("#dwclock").css("color", "#449d44");
                $("#hiveclock").css("color", "#d2322d");
            }
            else if (b == d){
                $("#dwclock").css("color", "#449d44");
                $("#hiveclock").css("color", "#449d44");
            }
            else {
                $("#dwclock").css("color", "#d2322d");
                $("#hiveclock").css("color", "#449d44");
            }
        }
        else
        {
            $("#dwclock").css("color", "#d2322d");
            $("#hiveclock").css("color", "#449d44");
        }

        setInterval(function () {
            $("#sec1").html(a);
        }, 1000);

        setInterval(function () {
            // Add a leading zero to the minutes value
            $("#msec1").html((b < 10 ? "00" : ( b < 100 ? "0" : "" )) + b);
        }, 1000);

        setInterval(function () {
            $("#sec2").html(c);
        }, 1000);

        setInterval(function () {
            // Add a leading zero to the minutes value
            $("#msec2").html((d < 10 ? "00" : ( d < 100 ? "0" : "" )) + d);
        }, 1000);

        setInterval(function () {
            $("#point1").html(".");
            $("#point2").html(".");
            $("#unit1").html("s");
            $("#unit2").html("s");
        }, 1000);

    })
}