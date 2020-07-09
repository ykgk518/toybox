import 'package:flutter/material.dart';
import 'package:picture_book/app.dart';
import 'package:picture_book/flower.dart';
import 'package:picture_book/login.dart';


void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Login(),
      routes: <String, WidgetBuilder>{
        '/login': (_) => new Login(),
        '/home': (_) => new PictureBookApp(),
        '/flower': (_) => new Flower()
      },
    );
  }
}
