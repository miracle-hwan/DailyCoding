import 'package:flutter/material.dart';

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
    return Container(
      color: Colors.amber,
    );
  }
}
