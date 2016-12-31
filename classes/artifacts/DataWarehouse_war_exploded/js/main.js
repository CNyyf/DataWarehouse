/**
 * Created by AMXPC on 2016/12/30.
 */
function wordscloud() {
    var myChart = echarts.init(document.getElementById('wordcloud'));
    var option = {
        title: {
            x: 'center',
            textStyle: {
                fontSize: 23
            }

        },
        backgroundColor: '#F7F7F7',
        tooltip: {
            show: true
        },
        toolbox: {
            feature: {
                saveAsImage: {
                    iconStyle: {
                        normal: {
                            color: '#FFFFFF'
                        }
                    }
                }
            }
        },
        series: [{
            name: 'Hot Points',
            type: 'wordCloud',
            size: ['9%', '99%'],
            sizeRange: [6, 66],
            //textRotation: [0, 45, 90, -45],
            rotationRange: [-45, 0, 45, 90],
            shape: 'circle',
            textPadding: 0,
            autoSize: {
                enable: true,
                minSize: 8
            },
            textStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' + [
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160)
                            ].join(',') + ')';
                    }
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            }
        }]
    };

    var JosnList = [];

    JosnList.push({
        name: 'Macys',
        value: 6181
    }, {
        name: 'Amy Schumer',
        value: 4386
    }, {
        name: 'Jurassic World',
        value: 4055
    }, {
        name: 'Charter Communications',
        value: 2467
    }, {
        name: 'Chick Fil A',
        value: 2244
    });

    option.series[0].data = JosnList;


    myChart.setOption(option);
    myChart.on('click', function (params) {
        //alert((params.name));
        window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));

    });
}

function submitJSON() {
	var checkboxYear = document.getElementsByName('checkboxA');
	var checkboxMonth = document.getElementsByName('checkboxB');
	var checkboxDay = document.getElementsByName('checkboxC');
	var section1 = $('#step1').children().eq(0);
	var valueYear = section1.children().eq(0).children().eq(2).children().eq(0).children().eq(1).children().eq(1).text();
	var valueMonth = section1.children().eq(2).children().eq(2).children().eq(0).children().eq(1).children().eq(1).text();
	var valueDay = section1.children().eq(4).children().eq(2).children().eq(0).children().eq(1).children().eq(1).text();
	var listDayofweek = document.getElementsByName('weeks');
	var valueDayofweek;
	for(var i = 0; i != listDayofweek.length; i++) {
		if(listDayofweek[i].className.indexOf('active') > -1) {
			valueDayofweek = listDayofweek[i].innerText;
		}
	}
	var listSeason = document.getElementsByName('seasons');
	var valueSeason;
	for(var i = 0; i != listSeason.length; i++) {
		if(listSeason[i].className.indexOf('active') > -1) {
			valueSeason = listSeason[i].innerText;
		}
	}
	var section2 = $('#step2').children().eq(0);
	var typeArea = section2.children().eq(0).children().eq(2).children();
	var valueListType = new Array();
	var valueMoviename = document.getElementById('inputMoviename').value;
	var valueDirector = document.getElementById('inputDirector').value;
	var valueStar = document.getElementById('inputStar').value;
	var valueActor = document.getElementById('inputActor').value;
	//alert(valueYear + "\n" + valueMonth + "\n" + valueDay + "\n" + valueDayofweek + "\n" + valueSeason + "\n" + valueMoviename + "\n" + valueDirector + "\n" + valueStar + "\n" + valueActor);
	var json = '';
	json += '{';
	json += '"moviename":"' + valueMoviename + '",';
	if(checkboxYear[0].checked == true) json += '"year":"' + valueYear + '",';
	else json += '"year":"",';
	if(checkboxMonth[0].checked == true) json += '"month":"' + valueMonth + '",';
	else json += '"month":"",';
	if(checkboxDay[0].checked == true) json += '"day":"' + valueDay + '",';
	else json += '"day":"",';
	json += '"dayofweek":"' + valueDayofweek + '",';
	json += '"season":"' + valueSeason + '",';
	json += '"director":"' + valueDirector + '",';
	json += '"star":"' + valueStar + '",';
	json += '"actor":"' + valueActor + '",';
	json += '"typeList":[';
	for(var i = 0; i != typeArea.size(); i++) {
		json += '"' + typeArea.eq(i).text() + '"';
		if(i != typeArea.size() - 1) {
			json += ',';
		}
	}
	json += ']';
	json += '}';
	document.getElementById('inputMain').value = json;
}