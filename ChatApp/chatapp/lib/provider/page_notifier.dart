import 'package:chatapp/home_page.dart';
import 'package:flutter/material.dart';

class PageNotifier extends ChangeNotifier {
  String _currentPage = HomePage.pageName;

  String get currentPage => _currentPage;

  void goToChat() {
    _currentPage = HomePage.pageName;
    notifyListeners();
  }

  void goToOtherPage(String name) {
    _currentPage = name;
    notifyListeners();
  }
}
