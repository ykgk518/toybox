import 'package:flutter/material.dart';
import 'package:picture_book/flower.dart';

class PictureBookApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "PictureBook",
      routes: <String, WidgetBuilder>{'/flower': (_) => new Flower()},
      home: Scaffold(
        appBar: _buildAppBar(context),
        body: _buildBody(context),
      ),
    );
  }

  Widget _buildAppBar(BuildContext context) {
    return AppBar(
      title: Text('図鑑一覧'),
      actions: <Widget>[
        IconButton(icon: const Icon(Icons.add_a_photo), onPressed: null)
      ],
    );
  }

  Widget _buildBody(context) {
    return Center(
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          ListTile(
              title: Text("お花の図鑑",
                  style: TextStyle(
                      fontSize: 30,
                      fontWeight: FontWeight.bold,
                      fontStyle: FontStyle.normal
                  )
              ),
              leading: Icon(Icons.add),
              onTap: () => Navigator.of(context).pushNamed("/flower")),
          Padding(
            padding: EdgeInsets.all(32.0),
            child: Text(
              "動物の図鑑",
              style: TextStyle(fontSize: 40),
            ),
          ),
          Padding(
            padding: EdgeInsets.symmetric(vertical: 16.0),
            child: Text("スポーツの図鑑"),
          )
        ],
      ),
    );
  }
}
