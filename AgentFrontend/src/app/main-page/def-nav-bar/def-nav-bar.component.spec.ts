import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DefNavBarComponent } from './def-nav-bar.component';

describe('DefNavBarComponent', () => {
  let component: DefNavBarComponent;
  let fixture: ComponentFixture<DefNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DefNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
