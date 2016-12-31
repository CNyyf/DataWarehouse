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