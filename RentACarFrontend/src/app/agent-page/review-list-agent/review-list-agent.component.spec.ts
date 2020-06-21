import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewListAgentComponent } from './review-list-agent.component';

describe('ReviewListAgentComponent', () => {
  let component: ReviewListAgentComponent;
  let fixture: ComponentFixture<ReviewListAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewListAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewListAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
