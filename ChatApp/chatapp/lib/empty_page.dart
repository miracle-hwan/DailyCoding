import 'package:chatapp/provider/page_notifier.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class EmptyPage extends Page {
  static final pageName = "EmptyPage";

  @override
  Route createRoute(BuildContext context) {
    return MaterialPageRoute(
        settings: this, builder: (context) => EmptyPageWidget());
  }
}

class EmptyPageWidget extends StatefulWidget {
  @override
  _EmptyPageWidgetState createState() => _EmptyPageWidgetState();
}

class _EmptyPageWidgetState extends State<EmptyPageWidget> {
  @override
  Widget build(BuildContext context) {
    return Material(
      child: InkWell(
        onTap: (){
          Provider.of<PageNotifier>(context, listen: false)
              .goToChat();
        },
        child: Container(
          color: Colors.amber,
        ),
      ),
    );
  }
}
