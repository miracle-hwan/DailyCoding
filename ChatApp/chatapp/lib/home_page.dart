import 'package:chatapp/chat_message.dart';
import 'package:chatapp/empty_page.dart';
import 'package:chatapp/provider/page_notifier.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class HomePage extends StatefulWidget {
  static final String pageName = "HomePage";

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  GlobalKey<AnimatedListState> animListKey = GlobalKey<AnimatedListState>();
  TextEditingController _textEditingController = TextEditingController();

  List<String> _chatMessages = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("MiracleChat"),
        actions: [
          IconButton(
              icon: Icon(Icons.add),
              onPressed: () {
                Provider.of<PageNotifier>(context, listen: false)
                    .goToOtherPage(EmptyPage.pageName);
              })
        ],
      ),
      body: Column(
        children: [
          Expanded(
              child: AnimatedList(
                  key: animListKey, reverse: true, itemBuilder: _buildItem)),
          Container(
            padding: EdgeInsets.symmetric(horizontal: 10),
            child: Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _textEditingController,
                    decoration: InputDecoration(hintText: "Input Message"),
                    onSubmitted: _handleSubmitted,
                  ),
                ),
                SizedBox(
                  width: 10,
                ),
                TextButton(
                    onPressed: () {
                      _handleSubmitted(_textEditingController.text);
                    },
                    child: Text("Send"),
                    style: TextButton.styleFrom(
                        primary: Colors.white, backgroundColor: Colors.brown))
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildItem(context, index, animation) {
    return ChatMessage(
      _chatMessages[index],
      animation: animation,
    );
  }

  void _handleSubmitted(String text) {
    _textEditingController.clear();
    _chatMessages.insert(0, text);
    animListKey.currentState.insertItem(0);
  }
}
