import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmationTranferComponent } from './confirmation-tranfer.component';

describe('ConfirmationTranferComponent', () => {
  let component: ConfirmationTranferComponent;
  let fixture: ComponentFixture<ConfirmationTranferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfirmationTranferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmationTranferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
