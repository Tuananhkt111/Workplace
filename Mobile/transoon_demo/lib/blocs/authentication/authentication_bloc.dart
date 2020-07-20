import 'package:equatable/equatable.dart';
import 'package:bloc/bloc.dart';
import 'package:transoondemo/repositories/user_repository.dart';
import 'package:meta/meta.dart';

part 'authentication_event.dart';
part 'authentication_state.dart';

class AuthenticationBloc extends Bloc<AuthenticationEvent, AuthenticationState> {
  final UserRepository _userRepository;

  AuthenticationBloc({@required UserRepository userRepository})
    : _userRepository = userRepository;

  @override
  AuthenticationState get initialState => Uninitialized();

  @override
  Stream<AuthenticationState> mapEventToState(AuthenticationEvent event) async* {
    switch(event.runtimeType) {
      case AppStarted: yield* _mapAppStartedToState(); break;
      case LoggedIn: yield* _mapLoggedInToState(); break;
      case LoggedOut: yield* _mapLoggedOutToState(); break;
    }
  }

  Stream<AuthenticationState> _mapAppStartedToState() async* {
    final isSignedIn = await _userRepository.isSignedIn();
    if(isSignedIn) {
      final name = await _userRepository.getUser();
      yield Authenticated(displayName: name);
    } else {
      yield Unauthenticated();
    }
  }

  Stream<AuthenticationState> _mapLoggedInToState() async* {
    yield Authenticated(displayName: await _userRepository.getUser());
  }

  Stream<AuthenticationState> _mapLoggedOutToState() async* {
    yield Unauthenticated();
    _userRepository.signOut();
  }
}