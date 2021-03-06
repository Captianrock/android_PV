# Android Performance Visualization for Android Applications

Performance of Android apps is a big concern for developers and testers, because mobile
devices impose constraints on the resources that can be used by the apps. In addition,
elements from the Android programming model such as the single­thread policy require
attention from developers to implement strategies aimed at reducing performance issues such
as GUI lagging and memory bloats.

Current tools for performance analysis (e.g., Eclipse MAT) lack automated performance
bottleneck detection capabilities, and developers prefer dynamic analysis­based techniques to
detect performance bottlenecks. In that sense, the goal of this project is to develop a hybrid
software tool (i.e., a web application and java code running on Android devices) that will help
android developers to analyze executions of Android apps (on real devices) by (i) visualizing hot
spots, and (ii) detecting performance bottlenecks. In that sense this project requires a module
for data collection on the device, and a web application for reporting the results.

The data collection on the device should be done using the Xposed framework
(http://repo.xposed.info/, https://github.com/rovo89/XposedBridge/wiki/Development­tutorial),
which allows to hook source code methods of an Android app, and collect dynamic information
meanwhile the app is executed in a real device. 

The visualizations will be provided in the web
module using an effective method for performance analysis called “flame graphs”; and the
performance bottlenecks detection should be done using anomaly detection techniques. The
web module should deliver a good and cool user experience to developers, therefore, the team
should use modern web and ORM frameworks such as JQuery, Bootstrap, AngularJS, Java
Server Faces, and JPA.

#Technologies Used

###Xposed framework
­ https://github.com/rovo89/XposedBridge/wiki/Development­tutorial
­ http://repo.xposed.info/

#References 

Performance bottlenecks:
­ Linares­Vasquez, M.; Vendome, C.; Qi Luo; Poshyvanyk, D., "How developers detect
and fix performance bottlenecks in Android apps," in Software Maintenance and
Evolution (ICSME), 2015 IEEE International Conference on , vol., no., pp.352­361, Sept.
29 2015­Oct. 1 2015

Flame graphs:
­ Bezemer, C.­P.; Pouwelse, J.; Gregg, B., "Understanding software performance
regressions using differential flame graphs," in Software Analysis, Evolution and
Reengineering (SANER), 2015 IEEE 22nd International Conference on , vol., no.,
pp.535­539, 2­6 March 2015
­ http://www.brendangregg.com/flamegraphs.html


