<%-- 
    Document   : chart
    Created on : Mar 20, 2024, 9:05:57 AM
    Author     : admin
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Temporarily use static data for testing
    String staticXValues = "[2018, 2019, 2020, 2021, 2022, 2023, 2024]";
    String staticYValues = "[456.25, 250.5, 381, 300, 506.05, 350.75, 955.8]";
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chart</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <style>
            /* Style for the line chart canvas */
            #myChart {
                box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
                margin: 20px auto;
                width: 100%;
                max-width: 800px;
                height: 400px; /* set a fixed height */
                padding: 20px;
                background: #fff; /* optional */
            }

            /* Style for the pie chart container */
            #piechart-container {
                box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
                margin: 20px auto;
                width: 100%;
                max-width: 700px;
                height: 400px; /* set a fixed height */
                padding: 20px;
                background: #fff; /* optional */
            }

            /* Style for chart analysis */
            .chart-analysis {
                text-align: center;
                margin-top: 20px;
                font-size: 1.2em;
            }

            .chart-analysis h2 {
                font-size: 1.5em;
                margin-bottom: 10px;
            }

            .chart-analysis ul {
                list-style: none;
                padding: 0;
                margin: 0;
            }

            .chart-analysis ul li {
                margin-bottom: 5px;
            }

            .chart-analysis ul li span {
                display: inline-block;
                width: 20px;
                height: 10px;
                margin-right: 10px;
                border-radius: 3px;
            }

            /* General style for both charts */
            canvas, #piechart-container {
                transition: transform 0.2s ease-in-out;
            }

            /* Scale up on hover */
            canvas:hover, #piechart-container:hover {
                transform: scale(1.05);
            }

            /* Position charts side by side */
            #charts-container {
                display: flex;
                justify-content: center; /* center horizontally */
                align-items: flex-start;
                flex-wrap: wrap;
            }
            .chart-analysis ul li:nth-child(1) span {
                background-color: #FF5733;
            }
            .chart-analysis ul li:nth-child(2) span {
                background-color: #C70039;
            }
            .chart-analysis ul li:nth-child(3) span {
                background-color: #900C3F;
            }
            .chart-analysis ul li:nth-child(4) span {
                background-color: #581845;
            }
        </style>
    </head>
    <body style="background: #f7f7f7">
        <div id="charts-container">
            <!-- Biểu đồ dòng 
                thống kê tổng số tiền của những hóa đơn từ năm 2018 -2024
            -->
            
            <div style="flex: 1;">
                <canvas id="myChart"></canvas>
                <div class="chart-analysis">
                    <h2>Line Chart Analysis</h2>
                    <ul>
                        <li><span style="background-color: rgba(255, 99, 132, 1);"></span> Revenue for 2018: $456.25</li>
                        <li><span style="background-color: rgba(255, 99, 132, 0.8);"></span> Revenue for 2019: $250.5</li>
                        <li><span style="background-color: rgba(255, 99, 132, 0.6);"></span> Revenue for 2020: $381</li>
                        <li><span style="background-color: rgba(255, 99, 132, 0.4);"></span> Revenue for 2021: $300</li>
                        <li><span style="background-color: rgba(255, 99, 132, 0.2);"></span> Revenue for 2022: $506.05</li>
                        <li><span style="background-color: rgba(255, 99, 132, 0.1);"></span> Revenue for 2023: $350.75</li>
                        <li><span style="background-color: rgba(255, 99, 132, 0.05);"></span> Revenue for 2024: $955.8</li>
                    </ul>
                </div>
            </div>
            <!-- Biểu đồ tròn
              thống kê số sản phẩm đc bán theo category
            -->
            
            <div style="flex: 1;">
                <div id="piechart-container"></div>
                <div class="chart-analysis">
                    <h2>Pie Chart Analysis</h2>
                    <ul>
                        <li><span></span> Femal Diamonds: 10</li>
                        <li><span></span> Male Diamonds: 7</li>
                        <li><span></span> Cubic Zirconia Diamonds: 4</li>
                        <li><span></span> Lotus Essence Diamond: 4</li>
                    </ul>
                </div>
            </div>
        </div>


        <script type="text/javascript">
            // Temporarily use static data for testing
            const xValues = [2018, 2019, 2020, 2021, 2022, 2023, 2024];
            const yValues = [456.25, 250.5, 381, 300, 506.05, 350.75, 955.8];

            var chart = document.getElementById("myChart").getContext("2d");
            var myChart = new Chart(chart, {
                type: "line",
                data: {
                    labels: xValues,
                    datasets: [{
                            label: "Revenue",
                            backgroundColor: "rgba(255, 99, 132, 0.2)",
                            borderColor: "rgba(255, 99, 132, 1)",
                            data: yValues
                        }]
                },
                options: {
                    responsive: true,
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                    }
                }
            });

            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawPieChart);

            function drawPieChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Product', 'Number'],
                    ['Femal Diamonds', 10],
                    ['Male Diamonds', 7],
                    ['Cubic Zirconia Diamonds', 4],
                    ['Lotus Essence Diamond ', 4]
                ]);

                var options = {
                    title: 'My Products'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart-container'));
                chart.draw(data, options);
            }
        </script>
    </body>
</html>

