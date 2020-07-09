import 'package:flutter/material.dart';

class Flower extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: Container(
          child: Text('お花図鑑')
        ),
        centerTitle: true,
        backgroundColor: Colors.orange[400],
      ),
      body: new Container(
        padding: new EdgeInsets.all(32.0),
        child: new Center(
          child: new Column(
            children: <Widget>[
              Text('Sub'),
              RaisedButton(onPressed: () => Navigator.of(context).pop(), child: new Text('戻る'),)
            ],
          ),
        ),
      ),
    );
  }

  List<Widget> _buildTextList(BuildContext context) {

  }
  Widget _buildAppBar(context) {
    return Text('お花の一覧');
  }

  Widget _buildBody(context) {
    return ListView();
  }

}
