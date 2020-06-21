import {UserModel} from "./UserModel";

export class Message{

  id: number;
  sender: UserModel
  reciever: UserModel;
  subject: String;
  contentM: String;
  dateM: Date;

  constructor() {
  }
}
