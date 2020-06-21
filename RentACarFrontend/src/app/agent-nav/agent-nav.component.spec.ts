import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentNavComponent } from './agent-nav.component';

describe('AgentNavComponent', () => {
  let component: AgentNavComponent;
  let fixture: ComponentFixture<AgentNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
