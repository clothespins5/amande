import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {PaintNameComponent} from "../../presentational/paint-name/paint-name.component";
import {Paint} from "../../../../lib/models/paint";
import {PaintQueryService} from "../../../../lib/service/paint-query.service";
import {Subject, takeUntil} from "rxjs";
import {PaintCommandService} from "../../../../lib/service/paint-command.service";

@Component({
  selector: 'app-paint-management-table',
  standalone: true,
  imports: [
    MatButtonModule,
    MatTableModule,
    PaintNameComponent,
  ],
  template: `
    <div>
      <table mat-table [dataSource]="paints">
        <ng-container matColumnDef="position">
          <th mat-header-cell *matHeaderCellDef>No.</th>
          <td mat-cell *matCellDef="let element"></td>
        </ng-container>
        <ng-container matColumnDef="manufacturer">
          <th mat-header-cell *matHeaderCellDef>メーカー</th>
          <td mat-cell *matCellDef="let element"></td>
        </ng-container>
        <ng-container matColumnDef="name">
          <th mat-header-cell *matHeaderCellDef>Name</th>
          <td mat-cell *matCellDef="let element">
            <app-paint-name
              [initialValue]="element"
              (changed)="update($event)"
            ></app-paint-name>
          </td>
        </ng-container>
        <ng-container matColumnDef="rgb">
          <th mat-header-cell *matHeaderCellDef>RGB</th>
          <td mat-cell *matCellDef="let element">
            <span class="color-code" [style.background-color]="element.colorCode.value"></span>
            {{element.colorCode.value}}
          </td>
        </ng-container>
        <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
        <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
      </table>
      <button mat-raised-button color="primary" (click)="register()">登録</button>
    </div>
  `,
  styles: [`
    div
      min-height: 100vh
    .color-code
      display: inline-block
      width: 1rem
      height: 1rem
      border: solid 0.1rem black
      border-radius: 0.3rem
  `]
})
export class PaintManagementTableComponent implements OnInit, OnDestroy{
  displayedColumns: string[] = ['position', 'manufacturer', 'name', 'rgb'];
  paints: Paint[] = [];

  private _onDestroy$ = new Subject<boolean>();
  constructor(
    private commandService: PaintCommandService,
    private queryService: PaintQueryService
  ) { }

  ngOnInit(): void {
    this.queryService
      .list()
      .pipe(takeUntil(this._onDestroy$))
      .subscribe(paints => this.paints = paints);
  }

  update(paint: Paint) {
    this.commandService
      .changeName(paint)
      .pipe(takeUntil(this._onDestroy$))
      .subscribe();
  }
  register() {
    // for (const paint of this.paints) {
    //   this.queryService.create(paint.paintName.value, paint.colorCode.value);
    // }

  }

  ngOnDestroy(): void {
    this._onDestroy$.next(true);
    this._onDestroy$.unsubscribe();
  }


}


// export const paints: Paint[] = [
//   new Paint(new PaintName('ホワイト'), new ColorCode('rgb(255,255,255)')),
//   new Paint(new PaintName('コールドホワイト'), new ColorCode('rgb(255,255,255)')),
//   new Paint(new PaintName('グロスホワイト'), new ColorCode('rgb(255,255,255)')),
//   new Paint(new PaintName('オフホワイト'), new ColorCode('rgb(243,243,232)')),
//   new Paint(new PaintName('アイボリー'), new ColorCode('rgb(245,245,223)')),
//   new Paint(new PaintName('ライトフレッシュ'), new ColorCode('rgb(252,240,217)')),
//   new Paint(new PaintName('ペールサンド'), new ColorCode('rgb(210,199,154)')),
//   new Paint(new PaintName('ベージュ'), new ColorCode('rgb(221,204,143)')),
//   new Paint(new PaintName('サンドイエロー'), new ColorCode('rgb(220,199,113)')),
//   new Paint(new PaintName('ライトイエロー'), new ColorCode('rgb(255,235,87)')),
//   new Paint(new PaintName('レモンイエロー'), new ColorCode('rgb(254,240,0)')),
//   new Paint(new PaintName('ジャーマンイエロー'), new ColorCode('rgb(232,232,129)')),
//   new Paint(new PaintName('アイスイエロー'), new ColorCode('rgb(254,239,134)')),
//   new Paint(new PaintName('ディープイエロー'), new ColorCode('rgb(254,230,2)')),
//   new Paint(new PaintName('フラットイエロー'), new ColorCode('rgb(253,211,0)')),
//   new Paint(new PaintName('ゴールデンイエロー'), new ColorCode('rgb(248,201,81)')),
//   new Paint(new PaintName('ベーシックスキントーン'), new ColorCode('rgb(247,190,137)')),
//   new Paint(new PaintName('フラットフレッシュ'), new ColorCode('rgb(221,174,117)')),
//   new Paint(new PaintName('ダークフレッシュ'), new ColorCode('rgb(219,170,91)')),
//   new Paint(new PaintName('サニースキントーン'), new ColorCode('rgb(238,181,101)')),
//   new Paint(new PaintName('ミディアムフレッシュトーン'), new ColorCode('rgb(192,133,52)')),
//   new Paint(new PaintName('ライトオレンジ'), new ColorCode('rgb(239,133,0)')),
//   new Paint(new PaintName('ジャーマンオレンジ'), new ColorCode('rgb(232,80,15)')),
//   new Paint(new PaintName('ブライトオレンジ'), new ColorCode('rgb(233,97,35)')),
//   new Paint(new PaintName('クリアオレンジ'), new ColorCode('rgb(233,78,24)')),
//   new Paint(new PaintName('スカーレット'), new ColorCode('rgb(212,45,32)')),
//   new Paint(new PaintName('オレンジレッド'), new ColorCode('rgb(224,70,17)')),
//   new Paint(new PaintName('バーミリオン'), new ColorCode('rgb(209,37,32)')),
//   new Paint(new PaintName('ダークバーミリオン'), new ColorCode('rgb(193,30,35)')),
//   new Paint(new PaintName('カーマインレッド'), new ColorCode('rgb(182,32,40)')),
//   new Paint(new PaintName('フラットレッド'), new ColorCode('rgb(168,35,45)')),
//   new Paint(new PaintName('ダークレッド'), new ColorCode('rgb(158,64,60)')),
//   new Paint(new PaintName('レッド'), new ColorCode('rgb(148,42,48)')),
//   new Paint(new PaintName('バーントレッド'), new ColorCode('rgb(103,49,49)')),
//   new Paint(new PaintName('ブラックレッド'), new ColorCode('rgb(99,45,51)')),
//   new Paint(new PaintName('ベージュレッド'), new ColorCode('rgb(201,150,97)')),
//   new Paint(new PaintName('サーモンローズ'), new ColorCode('rgb(242,162,130)')),
//   new Paint(new PaintName('ブラウンローズ'), new ColorCode('rgb(205,134,110)')),
//   new Paint(new PaintName('オールドローズ'), new ColorCode('rgb(215,126,120)')),
//   new Paint(new PaintName('ピンク'), new ColorCode('rgb(214,116,147)')),
//   new Paint(new PaintName('サンセットレッド'), new ColorCode('rgb(191,35,86)')),
//   new Paint(new PaintName('マゼンタ'), new ColorCode('rgb(166,31,73)')),
//   new Paint(new PaintName('バイオレットレッド'), new ColorCode('rgb(111,36,66)')),
//   new Paint(new PaintName('パープル'), new ColorCode('rgb(132,71,105)')),
//   new Paint(new PaintName('ロイヤルパープル'), new ColorCode('rgb(76,29,101)')),
//   new Paint(new PaintName('ブルーバイオレット'), new ColorCode('rgb(125,82,146)')),
//   new Paint(new PaintName('バイオレット'), new ColorCode('rgb(71,40,102)')),
//   new Paint(new PaintName('ダークシーブルー'), new ColorCode('rgb(27,63,71)')),
//   new Paint(new PaintName('オックスフォードブルー'), new ColorCode('rgb(47,62,91)')),
//   new Paint(new PaintName('ダークプルシャンブルー'), new ColorCode('rgb(16,40,62)')),
//   new Paint(new PaintName('プルシャンブルー'), new ColorCode('rgb(20,80,108)')),
//   new Paint(new PaintName('ブルー'), new ColorCode('rgb(1,47,102)')),
//   new Paint(new PaintName('ダークブルー'), new ColorCode('rgb(1,82,130)')),
//   new Paint(new PaintName('ロイヤルブルー'), new ColorCode('rgb(52,76,136)')),
//   new Paint(new PaintName('ウルトラマリン'), new ColorCode('rgb(47,82,160)')),
//   new Paint(new PaintName('フラットブルー'), new ColorCode('rgb(26,99,144)')),
//   new Paint(new PaintName('ミディアムブルー'), new ColorCode('rgb(2,95,134)')),
//   new Paint(new PaintName('フィールドブルー'), new ColorCode('rgb(64,104,113)')),
//   new Paint(new PaintName('フレンチミラージュブルー'), new ColorCode('rgb(87,120,127)')),
//   new Paint(new PaintName('インターミディエイトブルー'), new ColorCode('rgb(93,125,130)')),
//   new Paint(new PaintName('グレーブルー'), new ColorCode('rgb(62,108,137)')),
//   new Paint(new PaintName('アズール'), new ColorCode('rgb(110,125,173)')),
//   new Paint(new PaintName('パステルブルー'), new ColorCode('rgb(100,133,154)')),
//   new Paint(new PaintName('ペールブルー'), new ColorCode('rgb(134,184,177)')),
//   new Paint(new PaintName('アンドレアブルー'), new ColorCode('rgb(5,131,198)')),
//   new Paint(new PaintName('ディープスカイブルー'), new ColorCode('rgb(8,159,221)')),
//   new Paint(new PaintName('スカイブルー'), new ColorCode('rgb(153,214,245)')),
//   new Paint(new PaintName('ライトターコイズ'), new ColorCode('rgb(2,144,163)')),
//   new Paint(new PaintName('ターコイズ'), new ColorCode('rgb(9,132,153)')),
//   new Paint(new PaintName('ブルーグリーン'), new ColorCode('rgb(8,143,145)')),
//   new Paint(new PaintName('エメラルド'), new ColorCode('rgb(6,138,99)')),
//   new Paint(new PaintName('ディープグリーン'), new ColorCode('rgb(1,106,65)')),
//   new Paint(new PaintName('パークグリーンフラット'), new ColorCode('rgb(4,133,86)')),
//   new Paint(new PaintName('インターミディエイトグリーン'), new ColorCode('rgb(57,144,69)')),
//   new Paint(new PaintName('ライトグリーン'), new ColorCode('rgb(0,156,70)')),
//   new Paint(new PaintName('グリーンスカイ'), new ColorCode('rgb(94,172,125)')),
//   new Paint(new PaintName('ライムグリーン'), new ColorCode('rgb(111,173,60)')),
//   new Paint(new PaintName('イエローグリーン'), new ColorCode('rgb(218,224,3)')),
//   new Paint(new PaintName('ゴールデンオリーブ'), new ColorCode('rgb(120,148,42)')),
//   new Paint(new PaintName('ジャーマンカムフラージュブライトグリーン'), new ColorCode('rgb(80,136,60)')),
//   new Paint(new PaintName('ミディアムオリーブ'), new ColorCode('rgb(31,112,40)')),
//   new Paint(new PaintName('オリーブグリーン'), new ColorCode('rgb(109,139,41)')),
//   new Paint(new PaintName('フラットグリーン'), new ColorCode('rgb(31,106,44)')),
//   new Paint(new PaintName('ユニフォームグリーン'), new ColorCode('rgb(80,126,47)')),
//   new Paint(new PaintName('ドイツ軍ユニフォーム色'), new ColorCode('rgb(31,96,82)')),
//   new Paint(new PaintName('ドイツ空軍カムフラージュグリーン'), new ColorCode('rgb(86,107,59)')),
//   new Paint(new PaintName('イエローオリーブ'), new ColorCode('rgb(32,57,44)')),
//   new Paint(new PaintName('ガンシップグリーン'), new ColorCode('rgb(57,105,89)')),
//   new Paint(new PaintName('ミリタリーグリーン'), new ColorCode('rgb(61,90,71)')),
//   new Paint(new PaintName('リフレクティブグリーン'), new ColorCode('rgb(73,103,67)')),
//   new Paint(new PaintName('オリーブブラウン'), new ColorCode('rgb(59,71,69)')),
//   new Paint(new PaintName('オリーブグレー'), new ColorCode('rgb(55,87,74)')),
//   new Paint(new PaintName('アメリカ軍オリーブドラブ'), new ColorCode('rgb(80,97,75)')),
//   new Paint(new PaintName('WWⅡロシア軍ユニフォーム色'), new ColorCode('rgb(98,111,80)')),
//   new Paint(new PaintName('アメリカ軍ダークグリーン'), new ColorCode('rgb(90,108,82)')),
//   new Paint(new PaintName('カムフラージュオリーブグリーン'), new ColorCode('rgb(57,86,72)')),
//   new Paint(new PaintName('ジャーマンカムフラージュダークグリーン'), new ColorCode('rgb(40,74,67)')),
//   new Paint(new PaintName('ブロンズグリーン'), new ColorCode('rgb(39,84,79)')),
//   new Paint(new PaintName('ジャーマンカムフラージュエクストラダークグリーン'), new ColorCode('rgb(44,81,74)')),
//   new Paint(new PaintName('ブラックグリーン'), new ColorCode('rgb(0,69,61)')),
//   new Paint(new PaintName('グリーングレー'), new ColorCode('rgb(135,127,87)')),
//   new Paint(new PaintName('WWⅡドイツ軍フィールドグレー'), new ColorCode('rgb(95,90,68)')),
//   new Paint(new PaintName('WWⅡドイツ軍カムフラージュベージュ'), new ColorCode('rgb(163,149,109)')),
//   new Paint(new PaintName('ストーングレー'), new ColorCode('rgb(153,157,124)')),
//   new Paint(new PaintName('WWⅡドイツ空軍ユニフォーム色'), new ColorCode('rgb(65,74,83)')),
//   new Paint(new PaintName('グリーングレー'), new ColorCode('rgb(182,206,193)')),
//   new Paint(new PaintName('ライトグリーンブルー'), new ColorCode('rgb(114,158,152)')),
//   new Paint(new PaintName('ライトシーグレー'), new ColorCode('rgb(154,184,184)')),
//   new Paint(new PaintName('パステルグリーン'), new ColorCode('rgb(168,193,150)')),
//   new Paint(new PaintName('デッキタン'), new ColorCode('rgb(197,205,184)')),
//   new Paint(new PaintName('ミディアムグレー'), new ColorCode('rgb(149,159,128)')),
//   new Paint(new PaintName('イエローグリーン'), new ColorCode('rgb(149,138,64)')),
//   new Paint(new PaintName('カーキグレー'), new ColorCode('rgb(144,133,84)')),
//   new Paint(new PaintName('グリーンブラウン'), new ColorCode('rgb(148,126,79)')),
//   new Paint(new PaintName('カーキ'), new ColorCode('rgb(151,148,93)')),
//   new Paint(new PaintName('ダークイエロー'), new ColorCode('rgb(161,149,78)')),
//   new Paint(new PaintName('WWⅡ 日本軍ユニフォーム色'), new ColorCode('rgb(155,135,65)')),
//   new Paint(new PaintName('ミドルストーン'), new ColorCode('rgb(162,154,83)')),
//   new Paint(new PaintName('グリーンオーカー'), new ColorCode('rgb(173,143,95)')),
//   new Paint(new PaintName('バフ'), new ColorCode('rgb(215,208,155)')),
//   new Paint(new PaintName('イエローオーカー'), new ColorCode('rgb(198,156,60)')),
//   new Paint(new PaintName('タンイエロー'), new ColorCode('rgb(184,152,85)')),
//   new Paint(new PaintName('ダークサンド'), new ColorCode('rgb(212,185,120)')),
//   new Paint(new PaintName('イラクサンド'), new ColorCode('rgb(186,161,108)')),
//   new Paint(new PaintName('デザートイエロー'), new ColorCode('rgb(178,145,66)')),
//   new Paint(new PaintName('ゴールドブラウン'), new ColorCode('rgb(189,137,29)')),
//   new Paint(new PaintName('オーカーブラウン'), new ColorCode('rgb(173,120,35)')),
//   new Paint(new PaintName('ジャーマンカムフラージュオレンジオーカー'), new ColorCode('rgb(164,132,76)')),
//   new Paint(new PaintName('ライトブラウン'), new ColorCode('rgb(190,117,68)')),
//   new Paint(new PaintName('アマランスレッド'), new ColorCode('rgb(205,58,37)')),
//   new Paint(new PaintName('オレンジブラウン'), new ColorCode('rgb(183,110,57)')),
//   new Paint(new PaintName('ブラウンサンド'), new ColorCode('rgb(173,126,90)')),
//   new Paint(new PaintName('コルクブラウン'), new ColorCode('rgb(168,123,87)')),
//   new Paint(new PaintName('タンアース'), new ColorCode('rgb(158,120,91)')),
//   new Paint(new PaintName('ベージュブラウン'), new ColorCode('rgb(122,87,65)')),
//   new Paint(new PaintName('レッドレザー'), new ColorCode('rgb(148,65,50)')),
//   new Paint(new PaintName('キャバルリーブラウン'), new ColorCode('rgb(133,54,52)')),
//   new Paint(new PaintName('サドルブラウン'), new ColorCode('rgb(141,86,71)')),
//   new Paint(new PaintName('マホガニーブラウン'), new ColorCode('rgb(134,73,62)')),
//   new Paint(new PaintName('フラットブラウン'), new ColorCode('rgb(119,68,59)')),
//   new Paint(new PaintName('イギリス軍ユニフォーム色'), new ColorCode('rgb(121,93,41)')),
//   new Paint(new PaintName('アメリカ軍フィールドドラブ'), new ColorCode('rgb(117,93,59)')),
//   new Paint(new PaintName('フラットアース'), new ColorCode('rgb(135,97,51)')),
//   new Paint(new PaintName('ジャーマンカムフラージュペールバイオレットブラウン'), new ColorCode('rgb(130,106,86)')),
//   new Paint(new PaintName('ジャーマンカムフラージュミディアムブラウン'), new ColorCode('rgb(113,39,41)')),
//   new Paint(new PaintName('ハルレッド'), new ColorCode('rgb(80,34,32)')),
//   new Paint(new PaintName('レザーブラウン'), new ColorCode('rgb(77,68,54)')),
//   new Paint(new PaintName('バーントアンバー'), new ColorCode('rgb(105,83,68)')),
//   new Paint(new PaintName('チョコレートブラウン'), new ColorCode('rgb(100,80,66)')),
//   new Paint(new PaintName('ジャーマンカムフラージュブラックブラウン'), new ColorCode('rgb(92,52,35)')),
//   new Paint(new PaintName('ホワイトグレー'), new ColorCode('rgb(237,239,239)')),
//   new Paint(new PaintName('シルバーグレー'), new ColorCode('rgb(223,225,214)')),
//   new Paint(new PaintName('ペールグレーブルー'), new ColorCode('rgb(199,213,211)')),
//   new Paint(new PaintName('スカイグレー'), new ColorCode('rgb(186,192,185)')),
//   new Paint(new PaintName('ライトグレー'), new ColorCode('rgb(158,162,155)')),
//   new Paint(new PaintName('ブルーグレーペール'), new ColorCode('rgb(166,172,167)')),
//   new Paint(new PaintName('ダークブルーグレー'), new ColorCode('rgb(93,119,117)')),
//   new Paint(new PaintName('ミディアムシーグレー'), new ColorCode('rgb(137,150,147)')),
//   new Paint(new PaintName('ダークシーグレー'), new ColorCode('rgb(130,128,121)')),
//   new Paint(new PaintName('ニュートラルグレー'), new ColorCode('rgb(100,120,122)')),
//   new Paint(new PaintName('ロンドングレー'), new ColorCode('rgb(81,90,99)')),
//   new Paint(new PaintName('バサルトグレー'), new ColorCode('rgb(89,105,95)')),
//   new Paint(new PaintName('ダークシーグリーン'), new ColorCode('rgb(35,69,67)')),
//   new Paint(new PaintName('ダークブルーグレー'), new ColorCode('rgb(71,85,77)')),
//   new Paint(new PaintName('グレーグリーン'), new ColorCode('rgb(73,88,82)')),
//   new Paint(new PaintName('ダークグレー'), new ColorCode('rgb(30,62,59)')),
//   new Paint(new PaintName('ジャーマングレー'), new ColorCode('rgb(19,46,46)')),
//   new Paint(new PaintName('ブラックグレー'), new ColorCode('rgb(42,53,56)')),
//   new Paint(new PaintName('ブラック'), new ColorCode('rgb(35,42,47)')),
//   new Paint(new PaintName('グロスブラック'), new ColorCode('rgb(0,0,0)')),
//   new Paint(new PaintName('シルバー'), new ColorCode('rgb(203,213,211)')),
//   new Paint(new PaintName('ゴールド'), new ColorCode('rgb(212,182,83)')),
//   new Paint(new PaintName('オールドゴールド'), new ColorCode('rgb(152,133,72)')),
//   new Paint(new PaintName('ブラス（真鍮色）'), new ColorCode('rgb(168,125,44)')),
//   new Paint(new PaintName('ブロンズ'), new ColorCode('rgb(120,111,55)')),
//   new Paint(new PaintName('カッパー'), new ColorCode('rgb(174,82,39)')),
//   new Paint(new PaintName('オイリースチール'), new ColorCode('rgb(122,125,115)')),
//   new Paint(new PaintName('ナチュラルスチール'), new ColorCode('rgb(135,139,132)')),
//   new Paint(new PaintName('ガンメタルグレー'), new ColorCode('rgb(96,105,100)')),
//   new Paint(new PaintName('ガンメタルブルー'), new ColorCode('rgb(51,70,60)')),
//   new Paint(new PaintName('スモーク'), new ColorCode('rgb(50,45,39)')),
//   new Paint(new PaintName('ウッドグレイン（木目）'), new ColorCode('rgb(194,106,75)')),
//   new Paint(new PaintName('ナチュラルウッドグレイン'), new ColorCode('rgb(234,204,90)')),
//   new Paint(new PaintName('透明イエロー'), new ColorCode('rgb(234,215,97)')),
//   new Paint(new PaintName('透明オレンジ'), new ColorCode('rgb(223,162,122)')),
//   new Paint(new PaintName('透明レッド'), new ColorCode('rgb(205,85,62)')),
//   new Paint(new PaintName('透明ブルー'), new ColorCode('rgb(141,155,171)')),
//   new Paint(new PaintName('透明グリーン'), new ColorCode('rgb(27,156,135)')),
//   new Paint(new PaintName('ホワイトグレーズ(上塗り用)'), new ColorCode('rgb(255,255,255)')),
//   new Paint(new PaintName('ベルデグリグレーズ(上塗り用)'), new ColorCode('rgb(220,229,193)')),
//   new Paint(new PaintName('タングレーズ(上塗り用)'), new ColorCode('rgb(227,121,73)')),
//   new Paint(new PaintName('ブラウングレーズ(上塗り用)'), new ColorCode('rgb(57,50,44)')),
//   new Paint(new PaintName('ブラックグレーズ(上塗り用)'), new ColorCode('rgb(34,24,21)')),
//   new Paint(new PaintName('蛍光イエロー'), new ColorCode('rgb(240,234,61)')),
//   new Paint(new PaintName('蛍光オレンジ'), new ColorCode('rgb(234,99,0)')),
//   new Paint(new PaintName('蛍光マゼンタ'), new ColorCode('rgb(230,64,144)')),
//   new Paint(new PaintName('蛍光ブルー'), new ColorCode('rgb(0,110,182)')),
//   new Paint(new PaintName('蛍光グリーン'), new ColorCode('rgb(160,203,86)')),
//   new Paint(new PaintName('シルバー（アルコール系）'), new ColorCode('rgb(210,217,220)')),
//   new Paint(new PaintName('ゴールド（アルコール系）'), new ColorCode('rgb(156,155,34)')),
//   new Paint(new PaintName('オールドゴールド（アルコール系）'), new ColorCode('rgb(197,184,12)')),
//   new Paint(new PaintName('リッチゴールド（アルコール系）'), new ColorCode('rgb(170,133,42)')),
//   new Paint(new PaintName('レッドゴールド（アルコール系）'), new ColorCode('rgb(207,148,2)')),
//   new Paint(new PaintName('グリーンゴールド（アルコール系）'), new ColorCode('rgb(140,121,37)')),
//   new Paint(new PaintName('ホワイトゴールド（アルコール系）'), new ColorCode('rgb(225,225,226)')),
//   new Paint(new PaintName('カッパー（アルコール系）'), new ColorCode('rgb(158,71,40)')),
//   new Paint(new PaintName('FIORE ファレホ プリムラ フレッシュカラー'), new ColorCode('rgb(253,234,220)')),
//   new Paint(new PaintName('FIORE ファレホ プリムラ タンフレッシュカラー'), new ColorCode('rgb(249,202,158)')),
// ]
