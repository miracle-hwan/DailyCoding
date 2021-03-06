import 'package:chatapp/empty_page.dart';
import 'package:chatapp/home_page.dart';
import 'package:chatapp/provider/page_notifier.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [ChangeNotifierProvider(create: (_) => PageNotifier())],
      child: MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.brown,
        ),
        home: Consumer<PageNotifier>(
          builder: (context, pageNotifier, child) {
            return Navigator(
              pages: [
                MaterialPage(
                    key: ValueKey(HomePage.pageName), child: HomePage()),
                if (pageNotifier.currentPage == EmptyPage.pageName) EmptyPage()
              ],
              onPopPage: (route, result) {
                if (!route.didPop(result)) {
                  return false;
                }
                return true;
              },
            );
          },
        ),
      ),
    );
  }
}
