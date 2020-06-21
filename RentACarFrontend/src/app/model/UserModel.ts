import {Message} from "./Message";

export class UserModel{

  id: number;
  username: String;
  password: String;
  uloga: UserType;
  inbox: Array<Message>;
  outbox: Array<Message>;
  permissions: Set<PermissionsEnum>;
  constructor() {
  }
}
