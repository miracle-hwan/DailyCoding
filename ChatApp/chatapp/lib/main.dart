import 'package:chatapp/empty_page.dart';
import 'package:chatapp/home_page.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  String currentPage = HomePage.pageName;

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.brown,
      ),
      home: Navigator(
        pages: [
          MaterialPage(key: ValueKey(HomePage.pageName), child: HomePage()),
          if (currentPage == EmptyPage.pageName) EmptyPage()
        ],
        onPopPage: (route, result) {
          if (!route.didPop(result)) {
            return false;
          }
          return true;
        },
      ),
    );
  }
}
