import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
  home: MyScaffold(),
  title: 'My app',
));

class MyScaffold extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Material(
      child: Column(
        children: <Widget>[
          MyAppBar(
            title: Text('Example Text', style: Theme.of(context).primaryTextTheme.headline6,),
          ),
          Expanded(
            child: Center(
              child: Text('Hello, world'),
            ),
          )
        ],
      ),
    );
  }
}

class MyAppBar extends StatelessWidget {
  MyAppBar({this.title});
  final Widget title;
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 60,
      padding: const EdgeInsets.symmetric(horizontal: 8.0),
      decoration: BoxDecoration(color: Colors.blue[500]),
      child: Row(
        children: <Widget>[
          IconButton(
            onPressed: null,
            icon: Icon(Icons.menu),
            iconSize: 19.0,
            tooltip: 'Navigation menu',
          ),
          Expanded(
            child: title,
          ),
          IconButton(
            icon: Icon(Icons.search),
            tooltip: 'Search',
            onPressed: null,
          )
        ],
      ),
    );
  }
}