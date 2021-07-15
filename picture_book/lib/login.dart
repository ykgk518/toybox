import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Login'),
      ),
      body: Center(
        child: Form(
            child: SingleChildScrollView(
              padding: EdgeInsets.symmetric(horizontal: 16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: <Widget>[
                  const SizedBox(height: 24.0),
                  TextFormField(
                    decoration: const InputDecoration(
                        border: const UnderlineInputBorder(),
                        labelText: 'User Id'
                    ),
                  ),
                  const SizedBox(height: 24.0),
                  TextFormField(
                    maxLength: 8,
                    decoration: InputDecoration(
                        border: const UnderlineInputBorder(),
                        labelText: 'Password'
                    ),
                  ),
                  const SizedBox(height: 24.0),
                  Center(
                    child: RaisedButton(
                      child: const Text('Login'),
                      onPressed: () => {
                      Navigator.of(context).pushNamed("/home")
                    },
                    ),
                  )
                ],
              ),
            )),
      ),
    );
  }
}
