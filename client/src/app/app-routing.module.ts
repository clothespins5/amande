import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FindPaintComponent} from './components/page/find-paint/find-paint.component';

const routes: Routes = [
  {path: '', component: FindPaintComponent},
  {
    path: 'find-paint',
    loadChildren: () => import('./components/page/find-paint/find-paint.module')
      .then((m) => m.FindPaintModule)
  },
  {
    path: 'paint-stock',
    loadChildren: () => import('./components/page/paint-stock/paint-stock.module')
      .then((m) => m.PaintStockModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
