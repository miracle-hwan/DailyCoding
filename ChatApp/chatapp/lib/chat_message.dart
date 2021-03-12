import 'package:flutter/material.dart';

class ChatMessage extends StatelessWidget {
  final String text;
  final Animation<double> animation;

  const ChatMessage(this.text, {@required this.animation, Key key})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: FadeTransition(
        opacity: animation,
        child: SizeTransition(
          sizeFactor: animation,
          axisAlignment: -1,
          child: Row(
            children: [
              CircleAvatar(
                backgroundColor: Colors.brown,
                child: Text("D"),
              ),
              SizedBox(
                width: 16,
              ),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      "Id or Name",
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                    Text(text)
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
