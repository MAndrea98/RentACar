import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GasTableComponent } from './gas-table.component';

describe('GasTableComponent', () => {
  let component: GasTableComponent;
  let fixture: ComponentFixture<GasTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GasTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GasTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
