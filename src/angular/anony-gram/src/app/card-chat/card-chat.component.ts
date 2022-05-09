import { Component, Inject, Input, OnInit } from '@angular/core';
import { ChatModel } from '../shared/models/chatModel';
import { MatCard, MatCardContent } from '@angular/material/card';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
  selector: 'app-card-chat',
  templateUrl: './card-chat.component.html',
  styleUrls: ['./card-chat.component.scss']
})
export class CardChatComponent implements OnInit {
  @Input()
  dataChat!: ChatModel;

  constructor() {
  }

  ngOnInit(): void {
  }

}
